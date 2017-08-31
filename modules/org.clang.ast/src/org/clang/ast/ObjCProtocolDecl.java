/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.ast;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.ASTContextGlobals.*;


/// \brief Represents an Objective-C protocol declaration.
///
/// Objective-C protocols declare a pure abstract type (i.e., no instance
/// variables are permitted).  Protocols originally drew inspiration from
/// C++ pure virtual functions (a C++ feature with nice semantics and lousy
/// syntax:-). Here is an example:
///
/// \code
/// \@protocol NSDraggingInfo <refproto1, refproto2>
/// - (NSWindow *)draggingDestinationWindow;
/// - (NSImage *)draggedImage;
/// \@end
/// \endcode
///
/// This says that NSDraggingInfo requires two methods and requires everything
/// that the two "referenced protocols" 'refproto1' and 'refproto2' require as
/// well.
///
/// \code
/// \@interface ImplementsNSDraggingInfo : NSObject \<NSDraggingInfo>
/// \@end
/// \endcode
///
/// ObjC protocols inspired Java interfaces. Unlike Java, ObjC classes and
/// protocols are in distinct namespaces. For example, Cocoa defines both
/// an NSObject protocol and class (which isn't allowed in Java). As a result,
/// protocols are referenced using angle brackets as follows:
///
/// id \<NSDraggingInfo> anyObjectThatImplementsNSDraggingInfo;
///
//<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1968,
 FQN="clang::ObjCProtocolDecl", NM="_ZN5clang16ObjCProtocolDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDeclE")
//</editor-fold>
public class ObjCProtocolDecl extends /*public*/ ObjCContainerDecl implements /*public*/ Redeclarable<ObjCProtocolDecl>, Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // ObjCProtocolDecl
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1772,
   FQN="clang::ObjCProtocolDecl::anchor", NM="_ZN5clang16ObjCProtocolDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::DefinitionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1972,
   FQN="clang::ObjCProtocolDecl::DefinitionData", NM="_ZN5clang16ObjCProtocolDecl14DefinitionDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl14DefinitionDataE")
  //</editor-fold>
  private static class/*struct*/ DefinitionData {
    // \brief The declaration that defines this protocol.
    public ObjCProtocolDecl /*P*/ Definition;
    
    /// \brief Referenced protocols
    public ObjCProtocolList ReferencedProtocols;
    //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::DefinitionData::DefinitionData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1972,
     FQN="clang::ObjCProtocolDecl::DefinitionData::DefinitionData", NM="_ZN5clang16ObjCProtocolDecl14DefinitionDataC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl14DefinitionDataC1Ev")
    //</editor-fold>
    public /*inline*/ DefinitionData() {
      // : ReferencedProtocols() 
      //START JInit
      this.ReferencedProtocols = new ObjCProtocolList();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Definition=" + Definition // NOI18N
                + ", ReferencedProtocols=" + ReferencedProtocols; // NOI18N
    }
  };
  
  /// \brief Contains a pointer to the data associated with this class,
  /// which will be NULL if this class has not yet been defined.
  ///
  /// The bit indicates when we don't need to check for out-of-date
  /// declarations. It will be set unless modules are enabled.
  /*friend*/public PointerBoolPair<DefinitionData /*P*/ > Data;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::data">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1987,
   FQN="clang::ObjCProtocolDecl::data", NM="_ZNK5clang16ObjCProtocolDecl4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl4dataEv")
  //</editor-fold>
  private DefinitionData /*&*/ data() /*const*/ {
    assert ((Data.getPointer() != null)) : "Objective-C protocol has no definition!";
    return $Deref(Data.getPointer());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::ObjCProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1774,
   FQN="clang::ObjCProtocolDecl::ObjCProtocolDecl", NM="_ZN5clang16ObjCProtocolDeclC1ERNS_10ASTContextEPNS_11DeclContextEPNS_14IdentifierInfoENS_14SourceLocationES7_PS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDeclC1ERNS_10ASTContextEPNS_11DeclContextEPNS_14IdentifierInfoENS_14SourceLocationES7_PS0_")
  //</editor-fold>
  private ObjCProtocolDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
      IdentifierInfo /*P*/ Id, SourceLocation nameLoc, 
      SourceLocation atStartLoc, 
      ObjCProtocolDecl /*P*/ PrevDecl) {
    // : ObjCContainerDecl(ObjCProtocol, DC, Id, nameLoc, atStartLoc), redeclarable_base(C), Data() 
    //START JInit
    super(Kind.ObjCProtocol, DC, Id, new SourceLocation(nameLoc), new SourceLocation(atStartLoc));
    this.Redeclarable$Flds = $Redeclarable(C);
    this.Data = new PointerBoolPair<DefinitionData /*P*/ >();
    //END JInit
    setPreviousDecl(PrevDecl);
    if ((PrevDecl != null)) {
      Data.$assign(PrevDecl.Data);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::allocateDefinitionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1839,
   FQN="clang::ObjCProtocolDecl::allocateDefinitionData", NM="_ZN5clang16ObjCProtocolDecl22allocateDefinitionDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl22allocateDefinitionDataEv")
  //</editor-fold>
  /*friend*/public void allocateDefinitionData() {
    assert (!(Data.getPointer() != null)) : "Protocol already has a definition!";
    Data.setPointer(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (getASTContext())*/ $new_uint_ASTContext$C_uint(getASTContext(), (type$ptr<?> New$Mem)->{
            return new DefinitionData();
         }));
    Data.getPointer().Definition = this;
  }

  
  /*typedef Redeclarable<ObjCProtocolDecl> redeclarable_base*/
//  public final class redeclarable_base extends Redeclarable<ObjCProtocolDecl>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::getNextRedeclarationImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1999,
   FQN="clang::ObjCProtocolDecl::getNextRedeclarationImpl", NM="_ZN5clang16ObjCProtocolDecl24getNextRedeclarationImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl24getNextRedeclarationImplEv")
  //</editor-fold>
  @Override protected/*private*/ ObjCProtocolDecl /*P*/ getNextRedeclarationImpl()/* override*/ {
    return getNextRedeclaration();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::getPreviousDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2002,
   FQN="clang::ObjCProtocolDecl::getPreviousDeclImpl", NM="_ZN5clang16ObjCProtocolDecl19getPreviousDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl19getPreviousDeclImplEv")
  //</editor-fold>
  @Override protected/*private*/ ObjCProtocolDecl /*P*/ getPreviousDeclImpl()/* override*/ {
    return getPreviousDecl$Redeclarable();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2005,
   FQN="clang::ObjCProtocolDecl::getMostRecentDeclImpl", NM="_ZN5clang16ObjCProtocolDecl21getMostRecentDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl21getMostRecentDeclImplEv")
  //</editor-fold>
  @Override protected/*private*/ ObjCProtocolDecl /*P*/ getMostRecentDeclImpl()/* override*/ {
    return getMostRecentDecl$Redeclarable();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1785,
   FQN="clang::ObjCProtocolDecl::Create", NM="_ZN5clang16ObjCProtocolDecl6CreateERNS_10ASTContextEPNS_11DeclContextEPNS_14IdentifierInfoENS_14SourceLocationES7_PS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl6CreateERNS_10ASTContextEPNS_11DeclContextEPNS_14IdentifierInfoENS_14SourceLocationES7_PS0_")
  //</editor-fold>
  public static ObjCProtocolDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        IdentifierInfo /*P*/ Id, 
        SourceLocation nameLoc, 
        SourceLocation atStartLoc, 
        ObjCProtocolDecl /*P*/ PrevDecl) {
    ObjCProtocolDecl /*P*/ Result = /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new ObjCProtocolDecl(C, DC, Id, new SourceLocation(nameLoc), new SourceLocation(atStartLoc), PrevDecl);
     });
    Result.Data.setInt(!C.getLangOpts().Modules);
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1796,
   FQN="clang::ObjCProtocolDecl::CreateDeserialized", NM="_ZN5clang16ObjCProtocolDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ObjCProtocolDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    ObjCProtocolDecl /*P*/ Result = /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new ObjCProtocolDecl(C, (DeclContext /*P*/ )null, (IdentifierInfo /*P*/ )null, new SourceLocation(), 
                new SourceLocation(), (ObjCProtocolDecl /*P*/ )null);
     });
    Result.Data.setInt(!C.getLangOpts().Modules);
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::getReferencedProtocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2018,
   FQN="clang::ObjCProtocolDecl::getReferencedProtocols", NM="_ZNK5clang16ObjCProtocolDecl22getReferencedProtocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl22getReferencedProtocolsEv")
  //</editor-fold>
  public /*const*/ ObjCProtocolList /*&*/ getReferencedProtocols() /*const*/ {
    assert (hasDefinition()) : "No definition available!";
    return data().ReferencedProtocols;
  }

  /*typedef ObjCProtocolList::iterator protocol_iterator*/
//  public final class protocol_iterator extends type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/>{ };
  /*typedef llvm::iterator_range<protocol_iterator> protocol_range*/
//  public final class protocol_range extends iterator_range<ObjCProtocolDecl /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::protocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2025,
   FQN="clang::ObjCProtocolDecl::protocols", NM="_ZNK5clang16ObjCProtocolDecl9protocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl9protocolsEv")
  //</editor-fold>
  public iterator_range<ObjCProtocolDecl /*P*/ /*const*/> protocols() /*const*/ {
    return new iterator_range<ObjCProtocolDecl /*P*/ /*const*/>(protocol_begin(), protocol_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::protocol_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2028,
   FQN="clang::ObjCProtocolDecl::protocol_begin", NM="_ZNK5clang16ObjCProtocolDecl14protocol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl14protocol_beginEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl>/*protocol_iterator*/ protocol_begin() /*const*/ {
    if (!hasDefinition()) {
      return ((type$ptr<ObjCProtocolDecl>/*protocol_iterator*/)null);
    }
    
    return data().ReferencedProtocols.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::protocol_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2034,
   FQN="clang::ObjCProtocolDecl::protocol_end", NM="_ZNK5clang16ObjCProtocolDecl12protocol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl12protocol_endEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl>/*protocol_iterator*/ protocol_end() /*const*/ {
    if (!hasDefinition()) {
      return ((type$ptr<ObjCProtocolDecl>/*protocol_iterator*/)null);
    }
    
    return data().ReferencedProtocols.end();
  }

  /*typedef ObjCProtocolList::loc_iterator protocol_loc_iterator*/
//  public final class protocol_loc_iterator extends /*const*/type$ptr<SourceLocation> /*P*/ { };
  /*typedef llvm::iterator_range<protocol_loc_iterator> protocol_loc_range*/
//  public final class protocol_loc_range extends iterator_range</*const*/ SourceLocation>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::protocol_locs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2043,
   FQN="clang::ObjCProtocolDecl::protocol_locs", NM="_ZNK5clang16ObjCProtocolDecl13protocol_locsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl13protocol_locsEv")
  //</editor-fold>
  public iterator_range</*const*/ SourceLocation> protocol_locs() /*const*/ {
    return new iterator_range</*const*/ SourceLocation>(protocol_loc_begin(), protocol_loc_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::protocol_loc_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2046,
   FQN="clang::ObjCProtocolDecl::protocol_loc_begin", NM="_ZNK5clang16ObjCProtocolDecl18protocol_loc_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl18protocol_loc_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<SourceLocation> /*P*/ protocol_loc_begin() /*const*/ {
    if (!hasDefinition()) {
      return ((/*const*/type$ptr<SourceLocation> /*P*/ )null);
    }
    
    return data().ReferencedProtocols.loc_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::protocol_loc_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2052,
   FQN="clang::ObjCProtocolDecl::protocol_loc_end", NM="_ZNK5clang16ObjCProtocolDecl16protocol_loc_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl16protocol_loc_endEv")
  //</editor-fold>
  public /*const*/type$ptr<SourceLocation> /*P*/ protocol_loc_end() /*const*/ {
    if (!hasDefinition()) {
      return ((/*const*/type$ptr<SourceLocation> /*P*/ )null);
    }
    
    return data().ReferencedProtocols.loc_end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::protocol_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2058,
   FQN="clang::ObjCProtocolDecl::protocol_size", NM="_ZNK5clang16ObjCProtocolDecl13protocol_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl13protocol_sizeEv")
  //</editor-fold>
  public /*uint*/int protocol_size() /*const*/ {
    if (!hasDefinition()) {
      return 0;
    }
    
    return data().ReferencedProtocols.size();
  }

  
  /// setProtocolList - Set the list of protocols that this interface
  /// implements.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::setProtocolList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2067,
   FQN="clang::ObjCProtocolDecl::setProtocolList", NM="_ZN5clang16ObjCProtocolDecl15setProtocolListEPKPS0_jPKNS_14SourceLocationERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl15setProtocolListEPKPS0_jPKNS_14SourceLocationERNS_10ASTContextE")
  //</editor-fold>
  public void setProtocolList(type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> List, /*uint*/int Num, 
                 /*const*/type$ptr<SourceLocation> /*P*/ Locs, final ASTContext /*&*/ C) {
    assert (hasDefinition()) : "Protocol is not defined";
    data().ReferencedProtocols.set(List, Num, Locs, C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::lookupProtocolNamed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1805,
   FQN="clang::ObjCProtocolDecl::lookupProtocolNamed", NM="_ZN5clang16ObjCProtocolDecl19lookupProtocolNamedEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl19lookupProtocolNamedEPNS_14IdentifierInfoE")
  //</editor-fold>
  public ObjCProtocolDecl /*P*/ lookupProtocolNamed(IdentifierInfo /*P*/ Name) {
    ObjCProtocolDecl /*P*/ PDecl = this;
    if (Name == getIdentifier()) {
      return PDecl;
    }
    
    for (ObjCProtocolDecl /*P*/ I : protocols())  {
      if (((PDecl = I.lookupProtocolNamed(Name)) != null)) {
        return PDecl;
      }
    }
    
    return null;
  }

  
  // Lookup a method. First, we search locally. If a method isn't
  // found, we search referenced protocols and class categories.
  
  // lookupMethod - Lookup a instance/class method in the protocol and protocols
  // it inherited.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::lookupMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1820,
   FQN="clang::ObjCProtocolDecl::lookupMethod", NM="_ZNK5clang16ObjCProtocolDecl12lookupMethodENS_8SelectorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl12lookupMethodENS_8SelectorEb")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ lookupMethod(Selector Sel, 
              boolean isInstance) /*const*/ {
    ObjCMethodDecl /*P*/ MethodDecl = null;
    
    // If there is no definition or the definition is hidden, we don't find
    // anything.
    /*const*/ ObjCProtocolDecl /*P*/ Def = getDefinition$Const();
    if (!(Def != null) || Def.isHidden()) {
      return null;
    }
    if (((MethodDecl = getMethod(new Selector(Sel), isInstance)) != null)) {
      return MethodDecl;
    }
    
    for (/*const*/ ObjCProtocolDecl /*P*/ I : protocols())  {
      if (((MethodDecl = I.lookupMethod(new Selector(Sel), isInstance)) != null)) {
        return MethodDecl;
      }
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::lookupInstanceMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2078,
   FQN="clang::ObjCProtocolDecl::lookupInstanceMethod", NM="_ZNK5clang16ObjCProtocolDecl20lookupInstanceMethodENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl20lookupInstanceMethodENS_8SelectorE")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ lookupInstanceMethod(Selector Sel) /*const*/ {
    return lookupMethod(new Selector(Sel), true/*isInstance*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::lookupClassMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2081,
   FQN="clang::ObjCProtocolDecl::lookupClassMethod", NM="_ZNK5clang16ObjCProtocolDecl17lookupClassMethodENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl17lookupClassMethodENS_8SelectorE")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ lookupClassMethod(Selector Sel) /*const*/ {
    return lookupMethod(new Selector(Sel), false/*isInstance*/);
  }

  
  /// \brief Determine whether this protocol has a definition.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::hasDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2086,
   FQN="clang::ObjCProtocolDecl::hasDefinition", NM="_ZNK5clang16ObjCProtocolDecl13hasDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl13hasDefinitionEv")
  //</editor-fold>
  public boolean hasDefinition() /*const*/ {
    // If the name of this protocol is out-of-date, bring it up-to-date, which
    // might bring in a definition.
    // Note: a null value indicates that we don't have a definition and that
    // modules are enabled.
    if (!(Data.getOpaqueValue() != null)) {
      getMostRecentDecl$Redeclarable$Const();
    }
    
    return (Data.getPointer() != null);
  }

  
  /// \brief Retrieve the definition of this protocol, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2098,
   FQN="clang::ObjCProtocolDecl::getDefinition", NM="_ZN5clang16ObjCProtocolDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl13getDefinitionEv")
  //</editor-fold>
  public ObjCProtocolDecl /*P*/ getDefinition() {
    return hasDefinition() ? Data.getPointer().Definition : null;
  }

  
  /// \brief Retrieve the definition of this protocol, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2103,
   FQN="clang::ObjCProtocolDecl::getDefinition", NM="_ZNK5clang16ObjCProtocolDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl13getDefinitionEv")
  //</editor-fold>
  public /*const*/ ObjCProtocolDecl /*P*/ getDefinition$Const() /*const*/ {
    return hasDefinition() ? Data.getPointer().Definition : null;
  }

  
  /// \brief Determine whether this particular declaration is also the 
  /// definition.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::isThisDeclarationADefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2109,
   FQN="clang::ObjCProtocolDecl::isThisDeclarationADefinition", NM="_ZNK5clang16ObjCProtocolDecl28isThisDeclarationADefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl28isThisDeclarationADefinitionEv")
  //</editor-fold>
  public boolean isThisDeclarationADefinition() /*const*/ {
    return getDefinition$Const() == this;
  }

  
  /// \brief Starts the definition of this Objective-C protocol.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::startDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1845,
   FQN="clang::ObjCProtocolDecl::startDefinition", NM="_ZN5clang16ObjCProtocolDecl15startDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl15startDefinitionEv")
  //</editor-fold>
  public void startDefinition() {
    allocateDefinitionData();
    
    // Update all of the declarations with a pointer to the definition.
    for (ObjCProtocolDecl /*P*/ RD : redeclarable_redecls())  {
      RD.Data.$assign(this.Data);
    }
  }

  
  /// Produce a name to be used for protocol's metadata. It comes either via
  /// objc_runtime_name attribute or protocol name.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::getObjCRuntimeNameAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1892,
   FQN="clang::ObjCProtocolDecl::getObjCRuntimeNameAsString", NM="_ZNK5clang16ObjCProtocolDecl26getObjCRuntimeNameAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl26getObjCRuntimeNameAsStringEv")
  //</editor-fold>
  public StringRef getObjCRuntimeNameAsString() /*const*/ {
    {
      ObjCRuntimeNameAttr /*P*/ ObjCRTName = getAttr(ObjCRuntimeNameAttr.class);
      if ((ObjCRTName != null)) {
        return ObjCRTName.getMetadataName();
      }
    }
    
    return getName();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2120,
   FQN="clang::ObjCProtocolDecl::getSourceRange", NM="_ZNK5clang16ObjCProtocolDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    if (isThisDeclarationADefinition()) {
      return super.getSourceRange();
    }
    
    return new SourceRange(getAtStartLoc(), getLocation());
  }

  
  /*typedef redeclarable_base::redecl_range redecl_range*/
//  public final class redecl_range extends iterator_range<ObjCProtocolDecl /*P*/ >{ };
  /*typedef redeclarable_base::redecl_iterator redecl_iterator*/
//  public final class redecl_iterator extends Redeclarable.<ObjCProtocolDecl>redecl_iterator{ };
  //JAVA: using Redeclarable<ObjCProtocolDecl>::redecls_begin;
  //JAVA: using Redeclarable<ObjCProtocolDecl>::redecls_end;
  //JAVA: using Redeclarable<ObjCProtocolDecl>::redecls;
  //JAVA: using Redeclarable<ObjCProtocolDecl>::getPreviousDecl;
  //JAVA: using Redeclarable<ObjCProtocolDecl>::getMostRecentDecl;
  //JAVA: using Redeclarable<ObjCProtocolDecl>::isFirstDecl;
  
  /// Retrieves the canonical declaration of this Objective-C protocol.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2137,
   FQN="clang::ObjCProtocolDecl::getCanonicalDecl", NM="_ZN5clang16ObjCProtocolDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public ObjCProtocolDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2138,
   FQN="clang::ObjCProtocolDecl::getCanonicalDecl", NM="_ZNK5clang16ObjCProtocolDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ ObjCProtocolDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getFirstDecl$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::collectPropertiesToImplement">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1853,
   FQN="clang::ObjCProtocolDecl::collectPropertiesToImplement", NM="_ZNK5clang16ObjCProtocolDecl28collectPropertiesToImplementERN4llvm8DenseMapISt4pairIPNS_14IdentifierInfoEjEPNS_16ObjCPropertyDeclENS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_S8_EEEERNS1_11SmallVectorIS8_Lj8EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl28collectPropertiesToImplementERN4llvm8DenseMapISt4pairIPNS_14IdentifierInfoEjEPNS_16ObjCPropertyDeclENS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_S8_EEEERNS1_11SmallVectorIS8_Lj8EEE")
  //</editor-fold>
  @Override public void collectPropertiesToImplement(final DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > /*&*/ PM, 
                              final SmallVector<ObjCPropertyDecl /*P*/ > /*&*/ PO) /*const*//* override*/ {
    {
      
      /*const*/ ObjCProtocolDecl /*P*/ PDecl = getDefinition$Const();
      if ((PDecl != null)) {
        for (ObjCPropertyDecl /*P*/ Prop : PDecl.properties()) {
          // Insert into PM if not there already.
          PM.insert_pair$KeyT$ValueT(std.make_pair_T_Ptr(std.make_pair_Ptr_bool2uint(Prop.getIdentifier(), Prop.isClassProperty()), 
                      Prop));
          PO.push_back(Prop);
        }
        // Scan through protocol's protocols.
        for (/*const*/ ObjCProtocolDecl /*P*/ PI : PDecl.protocols())  {
          PI.collectPropertiesToImplement(PM, PO);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::collectInheritedProtocolProperties">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1871,
   FQN="clang::ObjCProtocolDecl::collectInheritedProtocolProperties", NM="_ZNK5clang16ObjCProtocolDecl34collectInheritedProtocolPropertiesEPKNS_16ObjCPropertyDeclERN4llvm8DenseMapIPKS0_PS1_NS4_12DenseMapInfoIS7_EENS4_6detail12DenseMapPairIS7_S8_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolDecl34collectInheritedProtocolPropertiesEPKNS_16ObjCPropertyDeclERN4llvm8DenseMapIPKS0_PS1_NS4_12DenseMapInfoIS7_EENS4_6detail12DenseMapPairIS7_S8_EEEE")
  //</editor-fold>
  public void collectInheritedProtocolProperties(/*const*/ ObjCPropertyDecl /*P*/ Property, 
                                    final DenseMap</*const*/ ObjCProtocolDecl /*P*/ , ObjCPropertyDecl /*P*/ > /*&*/ PM) /*const*/ {
    {
      /*const*/ ObjCProtocolDecl /*P*/ PDecl = getDefinition$Const();
      if ((PDecl != null)) {
        boolean MatchFound = false;
        for (ObjCPropertyDecl /*P*/ Prop : PDecl.properties()) {
          if (Prop == Property) {
            continue;
          }
          if (Prop.getIdentifier() == Property.getIdentifier()) {
            PM.$set(PDecl, Prop);
            MatchFound = true;
            break;
          }
        }
        // Scan through protocol's protocols which did not have a matching property.
        if (!MatchFound) {
          for (/*const*/ ObjCProtocolDecl /*P*/ PI : PDecl.protocols())  {
            PI.collectInheritedProtocolProperties(Property, PM);
          }
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2146,
   FQN="clang::ObjCProtocolDecl::classof", NM="_ZN5clang16ObjCProtocolDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2147,
   FQN="clang::ObjCProtocolDecl::classofKind", NM="_ZN5clang16ObjCProtocolDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ObjCProtocol;
  }

  
  /*friend  class ASTReader*/
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolDecl::~ObjCProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1968,
   FQN="clang::ObjCProtocolDecl::~ObjCProtocolDecl", NM="_ZN5clang16ObjCProtocolDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    Redeclarable.super.$destroy$Redeclarable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public final ObjCProtocolDecl getPreviousDecl() { 
    return (ObjCProtocolDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
  } 
  
  @Override 
  public final ObjCProtocolDecl getPreviousDecl$Const() { 
    return (ObjCProtocolDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
  } 
   
  @Override 
  public final ObjCProtocolDecl getMostRecentDecl() { 
    return (ObjCProtocolDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
  } 
  
  @Override 
  public final ObjCProtocolDecl getMostRecentDecl$Const() { 
    return (ObjCProtocolDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
  } 
  
  @Override 
  public final boolean isFirstDecl() { 
    return Redeclarable.super.isFirstDecl$Redeclarable(); 
  } 


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final Redeclarable$Fields Redeclarable$Flds;// use return value of $Redeclarable();
  @Override public final Redeclarable$Fields $Redeclarable$Fields() { return Redeclarable$Flds; }
  
  @Override public String toString() {
    return "" + "Data=" + Data // NOI18N
              + super.toString(); // NOI18N
  }
}
