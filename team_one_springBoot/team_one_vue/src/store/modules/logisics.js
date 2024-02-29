import axios from "axios";

export default{
    namespaced:true,
    
    state:{
        logisics: []
    },

    mutations:{
        setWarehouseList(state,payload){
            state.logisics.push(payload)
        },
        clearWarehouseList(state){
            state.logisics.length=0
        }
    },
    actions:{
        async fetchList ({state,commit}){
            console.log('dispatch 호출')
            
            commit('clearWarehouseList')
        
            try{
                let response = await axios.get('http://localhost:8086/warehouse_list.vue',{},{
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
                commit('setWarehouseList', temp)
                temp={}
            }
            console.log('state 확인 : ', state.logisics)
            }catch(error){
                console.log(error)
            }
        }
    }
}