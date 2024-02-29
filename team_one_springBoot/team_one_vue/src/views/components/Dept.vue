<template>

<Outbound v-if="isOutboundOpen" :id="id" @outboundClose="closeOutbound()" v-bind:isOutboundOpen="isOutboundOpen" />
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>부서 목록</h6>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center justify-content-center table-hover mb-0">
          <thead>
            <tr>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                부서코드
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                부서명
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                전화번호
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                주소
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                우편번호
              </th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="d in deptList" v-bind:key="d.department_id">
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ d.department_id }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ d.de_name }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ d.tel }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ d.de_address }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ d.de_zip_code }}</p>
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

// import { useRouter } from 'vue-router'

export default {
    name: 'projects-table',
    setup() {
        
        // const router = useRouter()
        
        const store = useStore()

        const deptList = computed(() => {
            return store.state.deptList.deptList
        }) 

        onMounted(async () => {
            await store.dispatch('deptList/deptsList')
        })

        return {
            deptList
        }       
    },
}
</script>