<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>재무상태표</h6>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center justify-content-center table-hover mb-0">
          <thead>
            <tr class="text-uppercase font-weight-bolder opacity-7 ps-2 table-secondary">
              <th colspan="4">재무상태표</th>
            </tr>
          </thead>
          <tbody>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">문서</td>
              <td colspan="3">
                <div id="file_time"></div>
              </td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-primary">
              <td>자 산</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-warning">
              <td>I. 유 동 자 산</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber(finance.bank_assets + finance.trade_receivable + finance.vat_payment + finance.current_inventory) }}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">(1)당 좌 자 산</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber(finance.bank_assets + finance.trade_receivable + finance.vat_payment) }}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">현금 및 현금성자산(보통예금)</td>
              <td class="text-danger">{{ $filters.formatNumber(finance.bank_assets) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light text-warning fw-bold">매 출 채 권 (외상매출금)</td>
              <td class="text-danger">{{ $filters.formatNumber(finance.trade_receivable) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">부 가 세 대 급 금</td>
              <td class="text-danger">{{$filters.formatNumber(finance.vat_payment) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">(2) 재 고 자 산</td>
              <td class="text-danger">{{ $filters.formatNumber(finance.current_inventory) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">상품</td>
              <td class="text-danger">{{ $filters.formatNumber(finance.current_inventory) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-success">
              <td>자 산 총 계</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber(finance.bank_assets + finance.trade_receivable + finance.vat_payment + finance.current_inventory) }}</td>
            </tr>
            <!-- ============================================== -->
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-primary">
              <td>부채</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-warning">
              <td>I. 유 동 부 채</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber(finance.trade_payable + finance.vat_deposit) }}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light text-warning fw-bold">매 입 채 무(외상매입금)</td>
              <td class="text-danger">{{ $filters.formatNumber(finance.trade_payable) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">부 가 세 예 수 금</td>
              <td class="text-danger">{{ $filters.formatNumber(finance.vat_deposit) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-success">
              <td>부 채 총 계</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber(finance.trade_payable + finance.vat_deposit) }}</td>
            </tr>
            <!-- =================================================== -->
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-primary">
              <td>자 본</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-warning">
              <td>I. 자 본 금</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{$filters.formatNumber(30000000)}}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">자 본 금</td>
              <td class="text-danger">{{$filters.formatNumber(30000000)}}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-warning">
              <td>II.이 익 잉 여 금</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber((finance.bank_assets + finance.trade_receivable + finance.vat_payment + finance.inventory) - (finance.trade_payable + finance.vat_deposit) - 30000000) }}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="text-uppercase text-xxs font-weight-bolder opacity-7 ps-2 table-light">이 익 잉 여 금</td>
              <td class="text-danger">{{ $filters.formatNumber((finance.bank_assets + finance.trade_receivable + finance.vat_payment + finance.inventory) - (finance.trade_payable + finance.vat_deposit) - 30000000) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-success">
              <td>자 본 총 계</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber((finance.bank_assets + finance.trade_receivable + finance.vat_payment + finance.inventory) - (finance.trade_payable + finance.vat_deposit)) }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import { onMounted, computed} from 'vue'
import { useStore } from 'vuex'

export default {
  name: "finance-table",
  setup() {
    const store = useStore()

    const finance = computed(() => {
            return store.state.finance.main
        }) 

    onMounted(async () => {
        await store.dispatch('finance/fetchList')
    })
    console.log("sds",finance)
    return{
      finance,
    }
  }
};
</script>
