import axios from "axios";

export default{
    namespaced:true,
    
    state:{
        release: []
    },

    mutations:{
        setReleaseHistory(state,payload){
            state.release.push(payload)
        },
        clearReleaseHistory(state){
            state.release.length=0
        }
    },
    actions:{
        async fetchList ({state,commit}){
            console.log('dispatch 호출')
            
            commit('clearReleaseHistory')
        
            try{                                
                let response = await axios.get('http://localhost:8086/release_history_list.vue',{},{
                 headers:{
                    'Content-Type': 'application/json; charset=utf-8',
                 }   
                })
            console.log('response 확인', response)

            let release = {}
            for(let newData of response.data){
                for(const [key,value] of Object.entries(newData)){
                    release[key] = value ?? ''
                }
                commit('setReleaseHistory', release)
                release={}
            }
            console.log('state 확인 : ', state.release)
            }catch(error){
                console.log(error)
            }
        }
    }
}