package servlets;


import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.FileXml;
import clasinEx.classManeger;
import clasinEx.store;
import exceptions.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Scanner;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class FileUploadServet extends HttpServlet {
    private final String fileLoading = "../fileUploadWeb/filerchooseri.html";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("fileupload/form.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        classManeger transPool = null;
        FileXml fileXml = new FileXml();
        userManegerToServet user = UserUtils.getuser(getServletContext());
        HttpSession session = request.getSession();
        sessionAtt Att = (sessionAtt) session.getAttribute("Username");
        InputStream inp = null;
        Part filePart = request.getPart("fake-key-1");
        Collection<Part> parts = request.getParts();
        if (Att.getRole() == 2)
            out.println("you cant load xml file beacause you customer");
        else {

            // InputStream mapNameInputStream = mapNamePart.getInputStream();//


            try {
                int count = 1;
                for (Part part : parts) {
                    inp = part.getInputStream();
                    fileXml.setFile(inp);
                    if (count == 1)
                        break;
                }

                    //  mapNameInputStream.available();
                    transPool = fileXml.fileToGame();
                    fileXml.checkIdSame(transPool);
                    fileXml.checkExistallstores(transPool);
                    fileXml.checkitemsallnotsell(transPool);
                    fileXml.checkitemsnotsellmoretimeinallstores(transPool);
                    fileXml.checkallstoresnotlocation(transPool);
                    fileXml.checkSameocationinStores(transPool);
                    fileXml.checkOfferThatNotSoldInStore(transPool);
                    fileXml.chreckOfferNotFoundInFile(transPool);
                    boolean found=false;
                    for(classManeger obj:user.getObjs()) {
                        if (obj.getZoni().getNameZone().equals(transPool.getZoni().getNameZone())) {
                            found = true;
                            break;
                        }
                    }
                    if(found)
                    {
                        out.println("the obj exist");
                    }
                    else {
                        transPool.setNameStoreMan(Att.getUsername());
                        for(int i=0;i<transPool.getStores().getStoress().size();i++)
                        {
                            transPool.getStores().getStoress().get(i).setNameStoreManege(Att.getUsername());
                        }
                        Att.addobj(transPool);
                        session.setAttribute("Username", Att);
                        user.AddObj(transPool);
                    }

            } catch (idsameitemsorstoresexceptions e) {
                transPool = null;
                out.println(e.create());

            } catch (itemnotexitinrefexception e) {
                transPool=null;
                out.println(e.create());
            } catch (itemthatnotsellexception e) {
                transPool=null;
                out.println(e.create());

            } catch (itemsellmoreoneinstoreexception e) {
                transPool=null;
                out.println(e.create());
            } catch (locationofsoreexcept e) {
                transPool=null;
                out.println(e.create());
            } catch (sameLocationinStores e) {
                transPool = null;
                out.println(e.create());
            }
                catch (offerThatNotSoldInStore e) {
                    transPool=null;
                    out.println(e.create());
                } catch (offersthatnotFound e) {
                    transPool=null;
                    out.println(e.create());
                }
            catch(Exception e){
                    System.out.println("Error file upload");
                    out.println("File Uploded - Error !!!");
                    // out.write("You must write map name for upload a file");
                }
                out.println("File Uploded");
//        response.sendRedirect(fileLoading);
            }
        }


        private String readFromInputStream (InputStream inputStream){
            return new Scanner(inputStream).useDelimiter("\\Z").next();
        }


    }


