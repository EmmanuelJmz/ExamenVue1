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
        </b-breadcrumb>
      </div>
  
      <h1>Paginación</h1>
  
      <div>
        <b-container class="mt-5">
          <b-input placeholder="Buscar coche" v-model="filtro"></b-input>
          <b-table
            id="my-table"
            :items="obtenervehiculos"
            :per-page="perPage"
            :current-page="currentPage"
            :fields="fields"
            :sort-by.sync="sortBy"
            :sort-desc.sync="sortDesc"
            label-sort-asc=""
            label-sort-desc=""
            small
            :filter="filtro"
            @filtered="onFiltered"
          >
          
          </b-table>
          <div class="overflow-auto">
            <b-pagination
              v-model="currentPage"
              :total-rows="rows"
              :per-page="perPage"
              aria-controls="my-table"
            ></b-pagination>
  
            <p class="mt-3">Current Page: {{ currentPage }}</p>
          </div>
        </b-container>

      </div>
    </div>
  </template>
  
  

  <script>

  import vehiculoService from "./Servicio";

  export default {
    data() {
      return {
        items: [
        {
          text: 'Anterior',
          href: '#/Formulario'
        },
        {
          text: 'Siguiente',
          href: '#/'
        },
        {
          text: 'Páginacion',
          active: true
        }
      ],
        filtro: null,
        sortBy: "model",
        sortDesc: false,
        perPage: 5,
        rows: 0,
        currentPage: 1,
        vehiculos: [],
        fields: [
          { key: "brand", label: "Marca", sortable: true },
          { key: "model", label: "Modelo", sortable: true },
          { key: "serie", label: "Serie", sortable: true},
          { key: "year", label: "Año", sortable: true}
        ],
      };
    },
    methods: {
      async obtenervehiculos(ctx) {
        console.log(ctx);
        try {
          const data = await vehiculoService.obtenerVehiculosPaginados(
            parseInt(ctx.currentPage)-1,
            parseInt(ctx.perPage),
            ctx.sortBy
          );
          this.rows = data.totalElements;
          return data.content;
        } catch (error) {
          console.error(error);
          // Manejar errores (puedes mostrar un mensaje de error al usuario, por ejemplo)
        }
      },
      onFiltered(filteredItems) {
        this.currentPage = 1;
        this.rows = filteredItems.length;
      },
    },
  };
  </script>