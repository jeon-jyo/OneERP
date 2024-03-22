import axios from "axios"
import Swal from 'sweetalert2'

export default {
    // 반드시 namespaced 값이 true이어야 모듈 이름을 호출 가능
    namespaced: true,
    state:{
        inputWaname: [],
    },
    mutations:{
        setInputData(state,payload){
            console.log('payload',payload)
            state[`${payload}`] = payload
        },
        clearInputData(state){
            state.inputWaname = ''
        },
    },
    actions:{
        async insertInbound({commit}, payload){
            commit('clearInputData')
            console.log('insert param',payload)
           
            try{
                // parameter를 대입
                // 외부 api를 호출해서 response 변수에 response값을 받아옴
                let response = await axios.post('http://localhost:8086/inbound_insert_action.vue',payload,{
                    headers:{
                        'Content-Type': 'application/json; charset=utf-8',
                    }
                })
                Swal.fire({
                    title: response.data.resultMsg,
                          icon: response.data.result
                     })
                commit('clearInputdata')
            }catch(error){
                console.log(error)
            }
        }
        
    }
}