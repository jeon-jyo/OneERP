import axios from "axios";

export default{
    namespaced:true,
    
    state:{
        purchase: []
    },

    mutations:{
        setOrderList(state,payload){
            state.purchase.push(payload)
        },
        clearOrderList(state){
            state.purchase.length=0
        }
    },
    actions:{
        async fetchList ({state,commit}){
            console.log('dispatch 호출')
            
            commit('clearOrderList')
        
            try{
                let response = await axios.get('http://localhost:8086/purchase_in_list.vue',{},{
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
                commit('setOrderList', temp)
                temp={}
            }
            console.log('state 확인 : ', state.purchase)
            }catch(error){
                console.log(error)
            }
        }
    }
}