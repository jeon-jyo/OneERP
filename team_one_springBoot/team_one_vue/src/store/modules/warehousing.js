import axios from "axios";

export default{
    namespaced:true,
    
    state:{
        warehousing: []
    },

    mutations:{
        setWarehousingList(state,payload){
            state.warehousing.push(payload)
        },
        clearWarehousingList(state){
            state.warehousing.length=0
        }
    },
    actions:{
        async fetchList ({state,commit}){
            console.log('dispatch 호출')
            
            commit('clearWarehousingList')
        
            try{                                
                let response = await axios.get('http://localhost:8086/warehousing_list.vue',{},{
                 headers:{
                    'Content-Type': 'application/json; charset=utf-8',
                 }   
                })
            console.log('response 확인', response)

            let warehousing = {}
            for(let newData of response.data){
                for(const [key,value] of Object.entries(newData)){
                    warehousing[key] = value ?? ''
                }
                commit('setWarehousingList', warehousing)
                warehousing={}
            }
            console.log('state 확인 : ', state.warehousing)
            }catch(error){
                console.log(error)
            }
        }
    }
}