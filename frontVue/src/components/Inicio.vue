<template>
  <div>
    <b-navbar type="dark" variant="dark" fixed="top">
      <div>
        <b-button v-b-toggle.sidebar-no-header>
          <img
          src="../assets/sidebar.png"
          style="width: 20px;"
        />
        </b-button>
        <b-sidebar id="sidebar-no-header" aria-labelledby="sidebar-no-header-title" no-header shadow>
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
    <h1>Pagina principal</h1>

  </div>
</template>

<script>
export default {
  data() {
    return {
      items: [
        {
          text: 'Anterior',
          href: '#/Paginacion'
        },
        {
          text: 'Siguiente',
          href: '#/Formulario'
        },
        {
          text: 'Página de inicio',
          active: true
        }
      ]
    }
  }
}
</script>

<style scoped>

</style>
