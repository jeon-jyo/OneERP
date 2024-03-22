import axios from "axios";

export default{
    namespaced:true,
    
    state:{
        orderList: []
    },

    mutations:{
        setOrderList(state,payload){
            state.orderList.push(payload)
        },
        clearOrderList(state){
            state.orderList.length=0
        }
    },
    actions:{
        async fetchList ({state,commit}){
            console.log('dispatch 호출')
            
            commit('clearOrderList')
        
            try{
                let response = await axios.get('http://localhost:8086/order_list_sc.vue',{},{
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
            console.log('state 확인 : ', state.orderList)
            }catch(error){
                console.log(error)
            }
        }
    }
}