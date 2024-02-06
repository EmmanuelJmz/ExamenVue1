import axios from 'axios';

let API_URL = 'http://localhost:8080/api/vehiculos/page';

let API_URL2 = 'http://localhost:8080/api/vehiculos';

const obtenerVehiculosPaginados = async(page, size, sort) => {
    const params = {
        page,
        size,
        sort
    };
    try {
        const response = await axios.post(API_URL, null, {params});

        return response.data;
    } catch (error){
        throw error;
    }
};

const insertarVehiculo = async (brand, model, serie, year) => {
    try {
      const response = await axios.post(API_URL2, {
        brand: brand,
        model: model,
        serie: serie,
        year: year
      });
      return response.data;
    } catch (error) {
      throw error;
    }
  };

export default {
    obtenerVehiculosPaginados,
    insertarVehiculo
 };
