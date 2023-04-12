program ej11;
const
    VALORALTO = 'ZZZZ';
type
    regMae = record
        nombreProvincia: string;
        alfabetizados : integer;
        encuestados: integer;
    end;

    regDet = record
        nombreProvincia: string;
        codLocalidad: integer;
        alfabetizados: integer;
        encuestados: integer;
    end;

    maestro = file of regMae;
    detalle = file of regDet;
    vectorDetalle = array[1..2] of detalle;
    vectorReg = array[1..2] of regDet;


procedure leer (var archD: detalle; var regD: regDet);
begin
    if (not eof(archD)) then
        read (archD, regD)
    else
        regD.nombreProvincia := VALORALTO;    

end;


procedure minimo (var vectorD: vectorDetalle; var vectorR: vectorReg; var min: regDet);
var
    i, minIndice: integer;

begin
    min.nombreProvincia := 'ZZZZ';
    for i:= 1 to 2 do
        begin
            if (vectorR[i].nombreProvincia < min.nombreProvincia) then
                begin
                    min := vectorR[i];
                    minIndice := i;

                end;  

        end;
    
    leer (vectorD[minIndice], vectorR[minIndice]);


end;
procedure procesar (var vectorD: vectorDetalle; var archM: maestro);
var
    i: integer;
    min, actual: regDet;
    vectorR : vectorReg;
	regM: regMae;

begin
    for i := 1 to 2 do
        begin
            reset (vectorD[i]);  
            leer (vectorD[i], vectorR[i])   
        end;
    reset (archM);

    minimo(vectorD, vectorR, min);
    while (min.nombreProvincia <> VALORALTO) do
        begin
			actual := min;
			actual.encuestados := 0;
			actual.alfabetizados := 0;
			while (actual.nombreProvincia = min.nombreProvincia) do
				begin
					actual.encuestados := actual.encuestados + min.encuestados;
					actual.alfabetizados := actual.alfabetizados + min.alfabetizados;
					minimo (vectorD, vectorR, min);



				end;
			
			while (regM.nombreProvincia <> actual.nombreProvincia) do
				begin
				 	read (archM, regM); 
				end;
			regM.alfabetizados := regM.alfabetizados + actual.alfabetizados;
			regM.encuestados := regM.encuestados + actual.encuestados;
			seek(archM, FilePos(archM) - 1);
			Write (archM, regM);


        end;
	
	close (archM);





end; 

var
    regM: maestro;



