import axios from "axios";

export default{
    namespaced:true,
    
    state:{
        commute: []
    },

    mutations:{
        setOrderList(state,payload){
            state.commute.push(payload)
        },
        clearOrderList(state){
            state.commute.length=0
        }
    },
    actions:{
        async fetchList ({state,commit}){
            console.log('dispatch 호출')
            
            commit('clearOrderList')
        
            try{
                let response = await axios.get('http://localhost:8086/vue_per_attend_list_call.vue',{},{
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