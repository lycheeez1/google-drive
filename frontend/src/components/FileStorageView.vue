<template>

    <v-data-table
        :headers="headers"
        :items="fileStorage"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'FileStorageView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "fileSize", value: "fileSize" },
                { text: "fileName", value: "fileName" },
                { text: "videoUrl", value: "videoUrl" },
                { text: "fileId", value: "fileId" },
                { text: "userId", value: "userId" },
                { text: "uploadYn", value: "uploadYn" },
                { text: "indexYn", value: "indexYn" },
            ],
            fileStorage : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/fileStorages'))

            temp.data._embedded.fileStorages.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.fileStorage = temp.data._embedded.fileStorages;
        },
        methods: {
        }
    }
</script>

