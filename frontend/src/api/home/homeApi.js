import axiosClient from '../axiosClient';

export const homeApi = {
    getBanner: () => axiosClient.get('/home/banner'),
};