import axios from "axios";

export default{
    namespaced:true,
    
    state:{
        deptList: []
    },

    mutations:{
        setDeptList(state,payload){
            state.deptList.push(payload)
        },
        clearDeptList(state){
            state.deptList.length=0
        }
    },
    actions:{
        async deptsList ({state,commit}){
            console.log('dispatch 호출')
            
            commit('clearDeptList')
        
            try{
                let response = await axios.get('http://localhost:8086/dept_list.vue',{},{
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
                commit('setDeptList', temp)
                temp={}
            }
            console.log('state 확인 : ', state.deptList)
            }catch(error){
                console.log(error)
            }
        }
    }
}