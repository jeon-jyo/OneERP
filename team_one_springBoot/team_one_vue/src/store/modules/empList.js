import axios from "axios";

export default{
    namespaced:true,
    
    state:{
        empList: []
    },

    mutations:{
        setEmpList(state,payload){
            state.empList.push(payload)
        },
        clearEmpList(state){
            state.empList.length=0
        }
    },
    actions:{
        async fetchList ({state,commit}){
            console.log('dispatch 호출')
            
            commit('clearEmpList')
        
            try{
                let response = await axios.get('http://localhost:8086/emp_list.vue',{},{
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
                commit('setEmpList', temp)
                temp={}
            }
            console.log('state 확인 : ', state.empList)
            }catch(error){
                console.log(error)
            }
        }
    }
}