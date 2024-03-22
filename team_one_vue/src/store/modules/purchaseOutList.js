import axios from "axios";

export default{
    namespaced:true,
    
    state:{
        purchaseOutList: []
    },

    mutations:{
        setPurchaseOutList(state,payload){
            state.purchaseOutList.push(payload)
        },
        clearPurchaseOutList(state){
            state.purchaseOutList.length=0
        }
    },
    actions:{
        async fetchList ({state,commit}){
            console.log('dispatch 호출')
            
            commit('clearPurchaseOutList')
        
            try{
                let response = await axios.get('http://localhost:8086/purchase_out_list.vue',{},{
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
                commit('setPurchaseOutList', temp)
                temp={}
            }
            console.log('state 확인 : ', state.purchaseOutList)
            }catch(error){
                console.log(error)
            }
        }
    }
}