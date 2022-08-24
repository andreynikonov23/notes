/**
 * 
 */
function openAddPopup(){
    document.getElementById('add-popup').style.display='flex';
}
function closeAddPopup(){
    document.getElementById('add-popup').style.display='none';
}
function openUpdatePopup(id, name, text){
    document.getElementById('edit-popup').style.display='flex';
    document.getElementById('identify').value=id;
    document.getElementById('edit-name').value=name;
    document.getElementById('edit-text').value=text;
}
function closeUpdatePopup(){
    document.getElementById('edit-popup').style.display='none';
}
function openDeletePopup(id){
    document.getElementById('delete-popup').style.display='flex';
    document.getElementById('id-delete').value=id;
}
function closeDeletePopup(){
    document.getElementById('delete-popup').style.display='none';
}
