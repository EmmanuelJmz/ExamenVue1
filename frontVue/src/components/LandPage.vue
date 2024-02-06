<template>
  <div>
    <header class="bg-dark text-light text-center py-5">
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
          <router-link to="/" class="navbar-brand">
            <img
              src="https://gifdb.com/images/high/kuromi-spinning-in-3d-animation-ezrhdueoorv1lg1g.gif"
              alt="hero-image"
              class="img-fluid hero-image"
            />
          </router-link>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <router-link to="/" class="nav-link">Sitio principal</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/features" class="nav-link">Extras</router-link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <h1 class="display-4 mt-4">Landing Page Examen U1</h1>
      <a href="/" class="btn btn-primary btn-lg mt-3">Sitio principal</a>
    </header>

    <section class="container-fluid my-5">
      <h2 class="text-center mb-4">Key Features</h2>

      <div class="row">
        <div class="col-md-4 mb-4">
          <div class="card">
            <img
              src="https://picsum.photos/200/300"
              class="card-img-top"
              alt="Feature 1"
            />
            <div class="card-body">
              <h5 class="card-title">Feature 1</h5>
              <p class="card-text">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit.
              </p>
            </div>
          </div>
        </div>

        <div class="col-md-4 mb-4">
          <div class="card">
            <img
              src="https://picsum.photos/200/300"
              class="card-img-top"
              alt="Feature 2"
            />
            <div class="card-body">
              <h5 class="card-title">Feature 2</h5>
              <p class="card-text">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit.
              </p>
            </div>
          </div>
        </div>

        <div class="col-md-4 mb-4">
          <div class="card">
            <img
              src="https://picsum.photos/200/300"
              class="card-img-top"
              alt="Feature 3"
            />
            <div class="card-body">
              <h5 class="card-title">Feature 3</h5>
              <p class="card-text">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit.
              </p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <footer class="bg-dark text-light text-center py-3">
      <p>&copy; 2024 EmmanuelJmz Derechos Reservados.</p>
      <div class="social-icons mt-3">
        <a href="#" class="text-light me-3"><i class="fab fa-twitter"></i></a>
        <a href="#" class="text-light me-3"><i class="fab fa-facebook"></i></a>
        <a href="#" class="text-light me-3"><i class="fab fa-linkedin"></i></a>
        <a href="#" class="text-light"><i class="fab fa-instagram"></i></a>
      </div>
    </footer>
  </div>
</template>

<script>
export default {};
</script>

<style>
.hero-image {
  width: 100px;
  height: auto;
  object-fit: cover;
  border-radius: 10px;
}
</style>
