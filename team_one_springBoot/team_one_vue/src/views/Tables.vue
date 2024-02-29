<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-12">
        <temp-table />
      </div>
    </div>
  </div>
</template>

<script>
import TempTable from "./components/TempTable.vue";

export default {
  name: "tables",
  components: {
    TempTable,
  },
};
</script>
