import axios from "axios";

export default{
    namespaced:true,
    
    state:{
        arrival: []
    },

    mutations:{
        setArrivalHistory(state,payload){
            state.arrival.push(payload)
        },
        clearArrivalHistory(state){
            state.arrival.length=0
        }
    },
    actions:{
        async fetchList ({state,commit}){
            console.log('dispatch 호출')
            
            commit('clearArrivalHistory')
        
            try{                                
                let response = await axios.get('http://localhost:8086/arrival_history_list.vue',{},{
                 headers:{
                    'Content-Type': 'application/json; charset=utf-8',
                 }   
                })
            console.log('response 확인', response)

            let arrival = {}
            for(let newData of response.data){
                for(const [key,value] of Object.entries(newData)){
                    arrival[key] = value ?? ''
                }
                commit('setArrivalHistory', arrival)
                arrival={}
            }
            console.log('state 확인 : ', state.arrival)
            }catch(error){
                console.log(error)
            }
        }
    }
}