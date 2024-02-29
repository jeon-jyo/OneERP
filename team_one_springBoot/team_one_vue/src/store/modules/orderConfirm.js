
import axios from "axios"
import Swal from 'sweetalert2'

export default {
    namespaced: true,
    actions: {
        async updateslip({ commit }, payload) {
            console.log('update param:', payload)

            try {
                let response = await axios.post('http://localhost:8086/order_update.vue', payload, {
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8',
                    }
                })    

                console.log(response)
                
                console.log(commit);
                // response의 data로 beckend에서 넘겨준 값을 가져온다.
                
                Swal.fire({
                    title: response.data.resultMsg,
                           icon: response.data.result
                     })
                     
            } catch (error) {
                console.log(error)
            }
        }
    }
}