package com.example.restcountryfx;

import com.example.restcountryfx.Models.CountryDTO;
import com.example.restcountryfx.Services.FakeRestCountriesService;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.util.List;

public class RestCountriesController {
    @FXML
    public ComboBox comboRegions;
    @FXML
    public TableView<CountryDTO> tableCountry;
    @FXML
    public TableColumn<CountryDTO,String> countryNameColum;
    @FXML
    public ImageView imgFlag;
    @FXML
    public TextField txtCountry;
    @FXML
    public TextField txtCapital;
    @FXML
    public TextField txtPoblation;
    @FXML
    public TextField txtCoin;
    @FXML
    public Button btnClear;


    @FXML
    public void BtnClear() {
        txtPoblation.setText("");
        txtCountry.setText("");
        txtCoin.setText("");
        txtCapital.setText("");
        imgFlag.setImage(null);
    }
    @FXML
    public void initialize(){
        countryNameColum.setCellValueFactory(celldata -> new SimpleObjectProperty<>(celldata.getValue().getName()));
        FakeRestCountriesService fakeRestCountriesService = new FakeRestCountriesService();
        comboRegions.getItems().addAll(fakeRestCountriesService.getRegions());

        comboRegions.setOnAction(event -> {
            String selected = comboRegions.getSelectionModel().getSelectedItem().toString();
            ObservableList<CountryDTO> observableList = FXCollections.observableArrayList();
            observableList.addAll(fakeRestCountriesService.getCountriesByRegions(selected));
            tableCountry.setItems(observableList);
            //System.out.println("Elemento seleccionado: " + selected);
        });
    }
}