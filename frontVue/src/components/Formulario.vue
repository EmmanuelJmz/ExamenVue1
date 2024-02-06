<template>
  <div>
    <b-navbar type="dark" variant="dark" fixed="top">
      <div>
        <b-button v-b-toggle.sidebar-no-header>
          <img src="../assets/sidebar.png" style="width: 20px;" />
        </b-button>
        <b-sidebar
          id="sidebar-no-header"
          aria-labelledby="sidebar-no-header-title"
          no-header
          shadow
        >
          <template #default="{ hide }">
            <div class="p-3">
              <h4 id="sidebar-no-header-title">Navegación</h4>
              <nav class="mb-3">
                <b-nav vertical>
                  <b-nav-item href="#/" @click="hide">Pagina principal</b-nav-item>
                  <b-nav-item href="#/formulario" @click="hide">Formulario</b-nav-item>
                  <b-nav-item href="#/paginacion" @click="hide">Paginación</b-nav-item>
                </b-nav>
              </nav>
              <b-button variant="dark" block @click="hide">Close Sidebar</b-button>
            </div>
          </template>
        </b-sidebar>
      </div>
      <b-navbar-nav>
        <b-nav-item href="#/landingpage">Landing Page</b-nav-item>
      </b-navbar-nav>
    </b-navbar>

    <div>
      <b-breadcrumb :items="items">
        <h1>Formulario</h1>
      </b-breadcrumb>
    </div>

    <h1>Registro de Vehículo</h1>

    <b-container>
      <div>
        <b-form @submit.prevent="verificarFormulario" novalidate>
          <b-alert variant="danger" dismissible :show="errors.length > 0">
            <b>{{
              errors.length > 1
                ? "Por favor corrige los siguientes errores:"
                : "Por favor corrige el siguiente error:"
            }}</b>
            <ul>
              <li v-for="error in errors" :key="error">{{ error }}</li>
            </ul>
          </b-alert>

          <b-form-group
            id="marca-group"
            label="Marca"
            label-for="marca"
            :state="validAlphanumeric(marca) ? null : false"
          >
            <b-form-input
              id="marca"
              v-model="marca"
              type="text"
              name="marca"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="modelo-group"
            label="Modelo"
            label-for="modelo"
            :state="validAlphanumeric(modelo) ? null : false"
          >
            <b-form-input
              id="modelo"
              v-model="modelo"
              type="text"
              name="modelo"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="anio-group"
            label="Año de Fabricación"
            label-for="anio"
            :state="validAnio(anio) ? null : false"
          >
            <b-form-input
              id="anio"
              v-model="anio"
              type="number"
              name="anio"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="serie-group"
            label="Número de Serie"
            label-for="serie"
            :state="validSerie(serie) ? null : false"
          >
            <b-form-input
              id="serie"
              v-model="serie"
              type="text"
              name="serie"
              required
            ></b-form-input>
          </b-form-group>

          <b-button type="submit" variant="primary">Registrar Vehículo</b-button>
        </b-form>
      </div>
    </b-container>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      items: [
        {
          text: 'Anterior',
          href: '#/'
        },
        {
          text: 'Siguiente',
          href: '#/Paginacion'
        },
        {
          text: 'Formulario',
          active: true
        }
      ],
      errors: [],
      marca: null,
      modelo: null,
      anio: null,
      serie: null,
    };
  },
  methods: {
    async verificarFormulario() {
      this.errors = [];

      if (!this.validAlphanumeric(this.marca)) {
        this.errors.push("Marca debe ser alfanumérica.");
      }

      if (!this.validAlphanumeric(this.modelo)) {
        this.errors.push("Modelo debe ser alfanumérico.");
      }

      if (!this.validAnio(this.anio)) {
        this.errors.push("Año de Fabricación no puede ser mayor al actual.");
      }

      if (!this.validSerie(this.serie)) {
        this.errors.push("Número de Serie no cumple el formato requerido.");
      }

      if (!this.marca || !this.modelo || !this.anio || !this.serie) {
        this.errors.push("Todos los campos son obligatorios.");
      }

      if (this.errors.length === 0) {
        try {
          await this.insertarVehiculo(this.marca, this.modelo, this.anio, this.serie);
          this.marca = '';
          this.modelo = '';
          this.anio = '';
          this.serie = '';
        } catch (error) {
          this.errors.push("Error al insertar el vehículo.");
        }
      }
    },
    async insertarVehiculo(marca, modelo, anio, serie) {
      const API_URL = 'http://localhost:8080/api/vehiculos';
      try {
        const response = await axios.post(API_URL, {
          brand: marca,
          model: modelo,
          year: anio,
          serie: serie
        });
        return response.data;
      } catch (error) {
        throw error;
      }
    },
    validAlphanumeric(value) {
      const re = /^[a-zA-Z0-9]+$/;
      return re.test(value);
    },
    validAnio(value) {
      const anioActual = new Date().getFullYear();
      return value <= anioActual;
    },
    validSerie(value) {
      const re = /^[a-zA-Z]{4}\d{3}-\d{2}[a-zA-Z]{2}$/;
      return re.test(value);
    },
  },
};
</script>

<style></style>
