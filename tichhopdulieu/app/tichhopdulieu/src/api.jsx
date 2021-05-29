import axiosClient from "./axiosClient";

const jobApi = {
    search(params) {
        const url = "/api/filter";
        return axiosClient.get(url, { params }, {
            headers: { "X-Requested-With": "XMLHttpRequest" },
        });
    },
    getCount(params) {
        const url = "/api/count";
        return axiosClient.get(url, { params }, {
            headers: { "X-Requested-With": "XMLHttpRequest" },
        });
    },
    getALL() {
        const url = "/api/jobs";
        return axiosClient.get(url)
    },
    getJob(id) {
        const url = `/api/job/${id}`;
        return axiosClient.get(url, {
            headers: { "X-Requested-With": "XMLHttpRequest" },
        });
    },
};

export default jobApi;