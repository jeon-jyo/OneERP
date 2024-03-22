import axios from "axios";

export default{
    namespaced:true,
    
    state:{
        productList: []
    },

    mutations:{
        setProductList(state,payload){
            state.productList.push(payload)
        },
        clearProductList(state){
            state.productList.length=0
        }
    },
    actions:{
        async fetchList ({state,commit}, payload){
            console.log('dispatch 호출')
            
            commit('clearProductList')
            console.log('payload 호출', payload)
            try{
                let response = await axios.get('http://localhost:8086/inbound_insert.vue?request_id=' + payload, {}, {
                 headers:{
                    'Content-Type': 'application/json; charset=utf-8',
                 }   
                })
            console.log('response 확인', response)

            let temp = {}
            for(let newData of response.data){
                for(const [key,value] of Object.entries(newData)){
                    temp[key] = value ?? ''
                }
                commit('setProductList', temp)
                temp={}
            }
            console.log('state 확인 : ', state.productList)
            }catch(error){
                console.log(error)
            }
        }
    }
}