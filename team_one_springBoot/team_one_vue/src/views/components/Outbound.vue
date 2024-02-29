<template>
    <!-- telport는 html tag 작성순서와 상관없이
         해당 영역에 component를 렌더링한다는 의미 
        to로 자식 element를 public/index.html의 id에 렌더링 함 -->
    <teleport to = "#outbound">
        <!-- 반응형 데이터에 따라서 class나 style을 변경할 수 있다. -->
        <div class="outbound" :class="isOutboundOpen ? 'show' : ''">
            <div class="modal_body border border-info">
                <h2>(판매부)출고 요청</h2>
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                            <th>상품명</th>
                            <th>주문수량</th>
                            <th>창고명</th>
                            <th>재고수량</th>
                        </tr>
                        <tr v-for="(p,i) in productList" v-bind:key="p.request_id">
                            <td>{{p.pr_name }}
                                <input type="hidden" v-if="0==i" v-model="p.request_id" >
                            </td>
                            <td>{{p.re_qty }}</td>
                            <td>{{p.wa_name }}</td>
                            <td>{{p.la_qty }}</td>
                        </tr>
                        <br><br><br>
                        <tr style="border:none;">
                            <th colspan="4" style="border:none;">창고선택
                            <select v-model="inputWaname" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                <option v-for="p in productList.slice(0, 1)" v-bind:key="p.pr_name" :value="p.wh_id" >{{p.wa_name}}</option>
                            </select>
                            </th>
                        </tr>                                             
                    </tbody>
                </table>
                <br><br><br>
                <!-- 함수 바인딩 v:on을 @로 축약해 사용가능-->
                <button type="button" class="btn btn-outline-info" @click="outbound()">출고요청</button>
                <button type="button" class="btn btn-outline-danger" @click="closeOutbound()">취소</button>
            </div>
        </div>
    </teleport>
</template>

<script>
import { onUnmounted, ref, computed } from 'vue'
import { useStore } from 'vuex'

export default {
    name: 'outbound-vue',
    // Product.vue에서 넘긴 값을 받을 때 props, Product.vue로 전달할 때 emits
    props: {
        isOutboundOpen: Boolean
    },
    emits: ['outboundClose'],

    setup(props, { emit }) {
        const store = useStore();

        const inputWaname = ref('')
      
        const productList = computed(() => {
        return store.state.productList.productList
        }) 
        // 동일 의미
        // const inputName = ref(createData.inputNmae)
        // const inputBrand = ref(createData.inputBrand)
        // console.log('store data:', store.state.[모듈명].inputName)

        // watch를 통해 input태그에 입력한 값을 감지해서 newValue에 담아 create.js의 mutations:setInputData()의 payload로 전달
        // watch(inputWaname, (newValue) => {
        //     console.log('inputWaname:', newValue)
        //     store.commit('insertOutbound/setInputData', newValue)
        //     console.log('store data:', store.state.insertOutbound.inputWaname)
        // })

         // c-1. 화면에 입력받은 값을 등록하는 함수 작성
        const outbound = async() => {
            
            
            // c-2. 새 객체를 생성하고 backend의 jpa의 vo property에 맞춰서 key 값을 설정 => insert 위한 값전달 위해
            let regObj = {
               wa_name : inputWaname.value ?? '',
               request_id : productList.value[0].request_id ?? ''
            } 
            // c-3. actions를 호츨 (dispatch) => src/store/modules/create.js => action 내부의 createProduct() 함수 호출
            await store.dispatch('outBoundInsert/insertOutbound', regObj)
            await store.dispatch('listProduct/fetchList')

            // 입력이 끝나면 모달을 닫음(emit 으로 함수 호출)
            closeOutbound()

        }

        //emit으로 modal을 닫는 함수를 호출
        const closeOutbound = () =>{
            emit('outbound-close')
        }
        // Product.vue <Modal @modalClose="closeModal()"/> 추가


        // lifeCycle 모달이 닫힐 때 실행됨
        onUnmounted(() => {
            store.commit('insertOutbound/clearInputData')
        }) 
        return {
            inputWaname,
            outbound,
            closeOutbound,
            props,
            productList
        }
    }
}
</script>


<style>
    .modal {
        position: absolute;
        top: 0;
        left: 0;
        width: auto;
        height: auto;
        display: none;
        background-color: rgba(0, 0, 0, 0.4);
    }

    .modal.show {
        display: block;
    }

    .modal_body {
        position: absolute;
        top: 50%;
        left: 50%;
        width: auto;
        height: auto;
        padding: 40px;
        text-align: center;
        background-color: rgb(255, 255, 255);
        border-radius: 10px;
        box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);

        transform: translateX(-50%) translateY(-50%);
    } 
</style>