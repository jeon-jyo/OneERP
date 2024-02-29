<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>인사카드 조회</h6>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center justify-content-center table-hover mb-0">
          <thead>
            <tr>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                사번
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                이름
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                전화번호
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                이메일
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                입사명
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                부서명
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                직위
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                상태
              </th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="em in empList" v-bind:key="em.employee_id">
             <td>
                <p class="text-sm font-weight-bold mb-0">{{ em.employee_id }}</p>
              </td>
              <td>
								<p class="text-sm font-weight-bold mb-0">{{em.em_name}}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ em.em_phone }}</p>
              </td>
              <td> 
					    	<p class="text-sm font-weight-bold mb-0">{{em.em_email}}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ em.hire_date.substring(0, 10) }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{em.de_name}}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ em.po_name }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{em.em_status}}</p>
              </td>
            </tr>    
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>

import { onMounted, computed } from 'vue'
import { useStore } from 'vuex'

export default {
  name: "projects-table",
  setup() {
    const store = useStore()

    const empList = computed(() => {
            return store.state.empList.empList
        }) 

    onMounted(async () => {
        await store.dispatch('empList/fetchList')
    })

    return{
      empList
    }
  }
};
</script>