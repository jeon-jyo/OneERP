import axios from "axios";

export default{
    namespaced:true,
    
    state:{
        main: {}
    },

    mutations:{
        setOrderList(state,payload){
            state.main = (payload)
        },
        clearOrderList(state){
            state.main.length={}
        }
    },
    actions:{
        async fetchList ({state,commit}){
            console.log('dispatch 호출')
            
            commit('clearOrderList')
        
            try{
                let response = await axios.get('http://localhost:8086/main_vue.sc',{},{
                 headers:{
                    'Content-Type': 'application/json; charset=utf-8',
                 }   
                })
            console.log('response 확인', response)

            let temp = {}
                for(const [key,value] of Object.entries(response.data)){
                    temp[key] = value ?? ''
                }
                commit('setOrderList', temp)
                temp={}
            console.log('state 확인 : ', state.main)
            }catch(error){
                console.log(error)
            }
        }
    }
}