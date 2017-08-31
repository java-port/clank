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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;


/// ObjCImplementationDecl - Represents a class definition - this is where
/// method definitions are specified. For example:
///
/// @code
/// \@implementation MyClass
/// - (void)myMethod { /* do something */ }
/// \@end
/// @endcode
///
/// In a non-fragile runtime, instance variables can appear in the class
/// interface, class extensions (nameless categories), and in the implementation
/// itself, as well as being synthesized as backing storage for properties.
///
/// In a fragile runtime, instance variables are specified in the class
/// interface, \em not in the implementation. Nevertheless (for legacy reasons),
/// we allow instance variables to be specified in the implementation. When
/// specified, they need to be \em identical to the interface.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2461,
 FQN="clang::ObjCImplementationDecl", NM="_ZN5clang22ObjCImplementationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDeclE")
//</editor-fold>
public class ObjCImplementationDecl extends /*public*/ ObjCImplDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // ObjCImplementationDecl
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2086,
   FQN="clang::ObjCImplementationDecl::anchor", NM="_ZN5clang22ObjCImplementationDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  /// Implementation Class's super class.
  private ObjCInterfaceDecl /*P*/ SuperClass;
  /*friend*/public SourceLocation SuperLoc;
  
  /// \@implementation may have private ivars.
  private SourceLocation IvarLBraceLoc;
  private SourceLocation IvarRBraceLoc;
  
  /// Support for ivar initialization.
  /// \brief The arguments used to initialize the ivars
  /*friend*/public LazyCXXCtorInitializersPtr IvarInitializers;
  /*friend*/public /*uint*/int NumIvarInitializers;
  
  /// Do the ivars of this class require initialization other than
  /// zero-initialization?
  private /*JBIT bool*/ boolean HasNonZeroConstructors /*: 1*/;
  
  /// Do the ivars of this class require non-trivial destruction?
  private /*JBIT bool*/ boolean HasDestructors /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::ObjCImplementationDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2483,
   FQN="clang::ObjCImplementationDecl::ObjCImplementationDecl", NM="_ZN5clang22ObjCImplementationDeclC1EPNS_11DeclContextEPNS_17ObjCInterfaceDeclES4_NS_14SourceLocationES5_S5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDeclC1EPNS_11DeclContextEPNS_17ObjCInterfaceDeclES4_NS_14SourceLocationES5_S5_S5_S5_")
  //</editor-fold>
  private ObjCImplementationDecl(DeclContext /*P*/ DC, 
      ObjCInterfaceDecl /*P*/ classInterface, 
      ObjCInterfaceDecl /*P*/ superDecl, 
      SourceLocation nameLoc, SourceLocation atStartLoc) {
    this(DC, 
      classInterface, 
      superDecl, 
      nameLoc, atStartLoc, 
      new SourceLocation(), 
      new SourceLocation(), 
      new SourceLocation());
  }
  private ObjCImplementationDecl(DeclContext /*P*/ DC, 
      ObjCInterfaceDecl /*P*/ classInterface, 
      ObjCInterfaceDecl /*P*/ superDecl, 
      SourceLocation nameLoc, SourceLocation atStartLoc, 
      SourceLocation superLoc/*= SourceLocation()*/) {
    this(DC, 
      classInterface, 
      superDecl, 
      nameLoc, atStartLoc, 
      superLoc, 
      new SourceLocation(), 
      new SourceLocation());
  }
  private ObjCImplementationDecl(DeclContext /*P*/ DC, 
      ObjCInterfaceDecl /*P*/ classInterface, 
      ObjCInterfaceDecl /*P*/ superDecl, 
      SourceLocation nameLoc, SourceLocation atStartLoc, 
      SourceLocation superLoc/*= SourceLocation()*/, 
      SourceLocation IvarLBraceLoc/*= SourceLocation()*/) {
    this(DC, 
      classInterface, 
      superDecl, 
      nameLoc, atStartLoc, 
      superLoc, 
      IvarLBraceLoc, 
      new SourceLocation());
  }
  private ObjCImplementationDecl(DeclContext /*P*/ DC, 
      ObjCInterfaceDecl /*P*/ classInterface, 
      ObjCInterfaceDecl /*P*/ superDecl, 
      SourceLocation nameLoc, SourceLocation atStartLoc, 
      SourceLocation superLoc/*= SourceLocation()*/, 
      SourceLocation IvarLBraceLoc/*= SourceLocation()*/, 
      SourceLocation IvarRBraceLoc/*= SourceLocation()*/) {
    // : ObjCImplDecl(ObjCImplementation, DC, classInterface, nameLoc, atStartLoc), SuperClass(superDecl), SuperLoc(superLoc), IvarLBraceLoc(IvarLBraceLoc), IvarRBraceLoc(IvarRBraceLoc), IvarInitializers(null), NumIvarInitializers(0), HasNonZeroConstructors(false), HasDestructors(false) 
    //START JInit
    super(Kind.ObjCImplementation, DC, classInterface, new SourceLocation(nameLoc), new SourceLocation(atStartLoc));
    this.SuperClass = superDecl;
    this.SuperLoc = new SourceLocation(superLoc);
    this.IvarLBraceLoc = new SourceLocation(IvarLBraceLoc);
    this.IvarRBraceLoc = new SourceLocation(IvarRBraceLoc);
    this.IvarInitializers = new LazyCXXCtorInitializersPtr();
    this.NumIvarInitializers = 0;
    this.HasNonZeroConstructors = false;
    this.HasDestructors = false;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2088,
   FQN="clang::ObjCImplementationDecl::Create", NM="_ZN5clang22ObjCImplementationDecl6CreateERNS_10ASTContextEPNS_11DeclContextEPNS_17ObjCInterfaceDeclES6_NS_14SourceLocationES7_S7_S7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl6CreateERNS_10ASTContextEPNS_11DeclContextEPNS_17ObjCInterfaceDeclES6_NS_14SourceLocationES7_S7_S7_S7_")
  //</editor-fold>
  public static ObjCImplementationDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        ObjCInterfaceDecl /*P*/ ClassInterface, 
        ObjCInterfaceDecl /*P*/ SuperDecl, 
        SourceLocation nameLoc, 
        SourceLocation atStartLoc) {
    return Create(C, DC, 
        ClassInterface, 
        SuperDecl, 
        nameLoc, 
        atStartLoc, 
        new SourceLocation(), 
        new SourceLocation(), 
        new SourceLocation());
  }
  public static ObjCImplementationDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        ObjCInterfaceDecl /*P*/ ClassInterface, 
        ObjCInterfaceDecl /*P*/ SuperDecl, 
        SourceLocation nameLoc, 
        SourceLocation atStartLoc, 
        SourceLocation superLoc/*= SourceLocation()*/) {
    return Create(C, DC, 
        ClassInterface, 
        SuperDecl, 
        nameLoc, 
        atStartLoc, 
        superLoc, 
        new SourceLocation(), 
        new SourceLocation());
  }
  public static ObjCImplementationDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        ObjCInterfaceDecl /*P*/ ClassInterface, 
        ObjCInterfaceDecl /*P*/ SuperDecl, 
        SourceLocation nameLoc, 
        SourceLocation atStartLoc, 
        SourceLocation superLoc/*= SourceLocation()*/, 
        SourceLocation IvarLBraceLoc/*= SourceLocation()*/) {
    return Create(C, DC, 
        ClassInterface, 
        SuperDecl, 
        nameLoc, 
        atStartLoc, 
        superLoc, 
        IvarLBraceLoc, 
        new SourceLocation());
  }
  public static ObjCImplementationDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        ObjCInterfaceDecl /*P*/ ClassInterface, 
        ObjCInterfaceDecl /*P*/ SuperDecl, 
        SourceLocation nameLoc, 
        SourceLocation atStartLoc, 
        SourceLocation superLoc/*= SourceLocation()*/, 
        SourceLocation IvarLBraceLoc/*= SourceLocation()*/, 
        SourceLocation IvarRBraceLoc/*= SourceLocation()*/) {
    if ((ClassInterface != null) && ClassInterface.hasDefinition()) {
      ClassInterface = ClassInterface.getDefinition();
    }
    final ObjCInterfaceDecl finalClassInterface = ClassInterface;
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new ObjCImplementationDecl(DC, finalClassInterface, SuperDecl, 
                new SourceLocation(nameLoc), new SourceLocation(atStartLoc), new SourceLocation(superLoc), 
                new SourceLocation(IvarLBraceLoc), new SourceLocation(IvarRBraceLoc));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2104,
   FQN="clang::ObjCImplementationDecl::CreateDeserialized", NM="_ZN5clang22ObjCImplementationDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ObjCImplementationDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new ObjCImplementationDecl((DeclContext /*P*/ )null, (ObjCInterfaceDecl /*P*/ )null, (ObjCInterfaceDecl /*P*/ )null, 
                new SourceLocation(), new SourceLocation());
     });
  }

  
  /// init_iterator - Iterates through the ivar initializer list.
  /*typedef CXXCtorInitializer **init_iterator*/
//  public final class init_iterator extends type$ptr<CXXCtorInitializer /*P*/ /*P*/>{ };
  
  /// init_const_iterator - Iterates through the ivar initializer list.
  /*typedef CXXCtorInitializer *const *init_const_iterator*/
//  public final class init_const_iterator extends type$ptr<CXXCtorInitializer /*P*/ /*const*/ /*P*/>{ };
  
  /*typedef llvm::iterator_range<init_iterator> init_range*/
//  public final class init_range extends iterator_range<CXXCtorInitializer /*P*/ >{ };
  /*typedef llvm::iterator_range<init_const_iterator> init_const_range*/
//  public final class init_const_range extends iterator_range<CXXCtorInitializer /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2516,
   FQN="clang::ObjCImplementationDecl::inits", NM="_ZN5clang22ObjCImplementationDecl5initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl5initsEv")
  //</editor-fold>
  public iterator_range<CXXCtorInitializer /*P*/ > inits() {
    return new iterator_range<CXXCtorInitializer /*P*/ >(init_begin(), init_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2517,
   FQN="clang::ObjCImplementationDecl::inits", NM="_ZNK5clang22ObjCImplementationDecl5initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl5initsEv")
  //</editor-fold>
  public iterator_range<CXXCtorInitializer /*P*/ /*const*/> inits$Const() /*const*/ {
    return new iterator_range<CXXCtorInitializer /*P*/ /*const*/>(init_begin$Const(), init_end$Const());
  }

  
  /// init_begin() - Retrieve an iterator to the first initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::init_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2522,
   FQN="clang::ObjCImplementationDecl::init_begin", NM="_ZN5clang22ObjCImplementationDecl10init_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl10init_beginEv")
  //</editor-fold>
  public type$ptr<CXXCtorInitializer /*P*/ /*P*/> init_begin() {
    /*const*/ ObjCImplementationDecl /*P*/ ConstThis = this;
    return ((/*const_cast*/type$ptr<CXXCtorInitializer /*P*/ /*P*/>)(ConstThis.init_begin$Const()));
  }

  /// begin() - Retrieve an iterator to the first initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::init_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2123,
   FQN="clang::ObjCImplementationDecl::init_begin", NM="_ZNK5clang22ObjCImplementationDecl10init_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl10init_beginEv")
  //</editor-fold>
  public type$ptr<CXXCtorInitializer/*P*/>/*iterator*/ init_begin$Const() /*const*/ {
    return IvarInitializers.get(getASTContext().getExternalSource());
  }

  
  /// init_end() - Retrieve an iterator past the last initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::init_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2530,
   FQN="clang::ObjCImplementationDecl::init_end", NM="_ZN5clang22ObjCImplementationDecl8init_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl8init_endEv")
  //</editor-fold>
  public type$ptr<CXXCtorInitializer /*P*/ /*P*/> init_end() {
    return init_begin().$add(NumIvarInitializers);
  }

  /// end() - Retrieve an iterator past the last initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::init_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2534,
   FQN="clang::ObjCImplementationDecl::init_end", NM="_ZNK5clang22ObjCImplementationDecl8init_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl8init_endEv")
  //</editor-fold>
  public type$ptr<CXXCtorInitializer /*P*/ /*const*/ /*P*/> init_end$Const() /*const*/ {
    return init_begin$Const().$add(NumIvarInitializers);
  }

  /// getNumArgs - Number of ivars which must be initialized.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::getNumIvarInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2538,
   FQN="clang::ObjCImplementationDecl::getNumIvarInitializers", NM="_ZNK5clang22ObjCImplementationDecl22getNumIvarInitializersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl22getNumIvarInitializersEv")
  //</editor-fold>
  public /*uint*/int getNumIvarInitializers() /*const*/ {
    return NumIvarInitializers;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::setNumIvarInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2542,
   FQN="clang::ObjCImplementationDecl::setNumIvarInitializers", NM="_ZN5clang22ObjCImplementationDecl22setNumIvarInitializersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl22setNumIvarInitializersEj")
  //</editor-fold>
  public void setNumIvarInitializers(/*uint*/int numNumIvarInitializers) {
    NumIvarInitializers = numNumIvarInitializers;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::setIvarInitializers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2110,
   FQN="clang::ObjCImplementationDecl::setIvarInitializers", NM="_ZN5clang22ObjCImplementationDecl19setIvarInitializersERNS_10ASTContextEPPNS_18CXXCtorInitializerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl19setIvarInitializersERNS_10ASTContextEPPNS_18CXXCtorInitializerEj")
  //</editor-fold>
  public void setIvarInitializers(final ASTContext /*&*/ C, 
                     type$ptr<CXXCtorInitializer /*P*/ /*P*/> initializers, 
                     /*uint*/int numInitializers) {
    if ($greater_uint(numInitializers, 0)) {
      NumIvarInitializers = numInitializers;
      type$ptr<CXXCtorInitializer /*P*/ /*P*/> ivarInitializers = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new CXXCtorInitializer /*P*/ [NumIvarInitializers]);
      memcpy(ivarInitializers, initializers, 
          numInitializers, true);//  * $sizeof_ptr(/*CXXCtorInitializer  */));
      IvarInitializers.$assign(ivarInitializers);
    }
  }

  
  /// Do any of the ivars of this class (not counting its base classes)
  /// require construction other than zero-initialization?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::hasNonZeroConstructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2552,
   FQN="clang::ObjCImplementationDecl::hasNonZeroConstructors", NM="_ZNK5clang22ObjCImplementationDecl22hasNonZeroConstructorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl22hasNonZeroConstructorsEv")
  //</editor-fold>
  public boolean hasNonZeroConstructors() /*const*/ {
    return HasNonZeroConstructors;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::setHasNonZeroConstructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2553,
   FQN="clang::ObjCImplementationDecl::setHasNonZeroConstructors", NM="_ZN5clang22ObjCImplementationDecl25setHasNonZeroConstructorsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl25setHasNonZeroConstructorsEb")
  //</editor-fold>
  public void setHasNonZeroConstructors(boolean val) {
    HasNonZeroConstructors = val;
  }

  
  /// Do any of the ivars of this class (not counting its base classes)
  /// require non-trivial destruction?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::hasDestructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2557,
   FQN="clang::ObjCImplementationDecl::hasDestructors", NM="_ZNK5clang22ObjCImplementationDecl14hasDestructorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl14hasDestructorsEv")
  //</editor-fold>
  public boolean hasDestructors() /*const*/ {
    return HasDestructors;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::setHasDestructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2558,
   FQN="clang::ObjCImplementationDecl::setHasDestructors", NM="_ZN5clang22ObjCImplementationDecl17setHasDestructorsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl17setHasDestructorsEb")
  //</editor-fold>
  public void setHasDestructors(boolean val) {
    HasDestructors = val;
  }

  
  /// getIdentifier - Get the identifier that names the class
  /// interface associated with this implementation.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2562,
   FQN="clang::ObjCImplementationDecl::getIdentifier", NM="_ZNK5clang22ObjCImplementationDecl13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl13getIdentifierEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifier() /*const*/ {
    return getClassInterface$Const().getIdentifier();
  }

  
  /// getName - Get the name of identifier for the class interface associated
  /// with this implementation as a StringRef.
  //
  // FIXME: This is a bad API, we are hiding NamedDecl::getName with a different
  // meaning.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2571,
   FQN="clang::ObjCImplementationDecl::getName", NM="_ZNK5clang22ObjCImplementationDecl7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    assert ((getIdentifier() != null)) : "Name is not a simple identifier";
    return getIdentifier().getName();
  }

  
  /// @brief Get the name of the class associated with this interface.
  //
  // FIXME: Move to StringRef API.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::getNameAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2579,
   FQN="clang::ObjCImplementationDecl::getNameAsString", NM="_ZNK5clang22ObjCImplementationDecl15getNameAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl15getNameAsStringEv")
  //</editor-fold>
  public std.string getNameAsString() /*const*/ {
    return getName().$string();
  }

  
  /// Produce a name to be used for class's metadata. It comes either via
  /// class's objc_runtime_name attribute or class name.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::getObjCRuntimeNameAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1472,
   FQN="clang::ObjCImplementationDecl::getObjCRuntimeNameAsString", NM="_ZNK5clang22ObjCImplementationDecl26getObjCRuntimeNameAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl26getObjCRuntimeNameAsStringEv")
  //</editor-fold>
  public StringRef getObjCRuntimeNameAsString() /*const*/ {
    {
      ObjCInterfaceDecl /*P*/ ID = ((/*const_cast*/ObjCImplementationDecl /*P*/ )(this)).getClassInterface();
      if ((ID != null)) {
        return ID.getObjCRuntimeNameAsString();
      }
    }
    
    return getName();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::getSuperClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2587,
   FQN="clang::ObjCImplementationDecl::getSuperClass", NM="_ZNK5clang22ObjCImplementationDecl13getSuperClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl13getSuperClassEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ getSuperClass$Const() /*const*/ {
    return SuperClass;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::getSuperClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2588,
   FQN="clang::ObjCImplementationDecl::getSuperClass", NM="_ZN5clang22ObjCImplementationDecl13getSuperClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl13getSuperClassEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getSuperClass() {
    return SuperClass;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::getSuperClassLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2589,
   FQN="clang::ObjCImplementationDecl::getSuperClassLoc", NM="_ZNK5clang22ObjCImplementationDecl16getSuperClassLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl16getSuperClassLocEv")
  //</editor-fold>
  public SourceLocation getSuperClassLoc() /*const*/ {
    return new SourceLocation(SuperLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::setSuperClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2591,
   FQN="clang::ObjCImplementationDecl::setSuperClass", NM="_ZN5clang22ObjCImplementationDecl13setSuperClassEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl13setSuperClassEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public void setSuperClass(ObjCInterfaceDecl /*P*/ superCls) {
    SuperClass = superCls;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::setIvarLBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2593,
   FQN="clang::ObjCImplementationDecl::setIvarLBraceLoc", NM="_ZN5clang22ObjCImplementationDecl16setIvarLBraceLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl16setIvarLBraceLocENS_14SourceLocationE")
  //</editor-fold>
  public void setIvarLBraceLoc(SourceLocation Loc) {
    IvarLBraceLoc.$assign(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::getIvarLBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2594,
   FQN="clang::ObjCImplementationDecl::getIvarLBraceLoc", NM="_ZNK5clang22ObjCImplementationDecl16getIvarLBraceLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl16getIvarLBraceLocEv")
  //</editor-fold>
  public SourceLocation getIvarLBraceLoc() /*const*/ {
    return new SourceLocation(IvarLBraceLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::setIvarRBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2595,
   FQN="clang::ObjCImplementationDecl::setIvarRBraceLoc", NM="_ZN5clang22ObjCImplementationDecl16setIvarRBraceLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl16setIvarRBraceLocENS_14SourceLocationE")
  //</editor-fold>
  public void setIvarRBraceLoc(SourceLocation Loc) {
    IvarRBraceLoc.$assign(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::getIvarRBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2596,
   FQN="clang::ObjCImplementationDecl::getIvarRBraceLoc", NM="_ZNK5clang22ObjCImplementationDecl16getIvarRBraceLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl16getIvarRBraceLocEv")
  //</editor-fold>
  public SourceLocation getIvarRBraceLoc() /*const*/ {
    return new SourceLocation(IvarRBraceLoc);
  }

  
  /*typedef specific_decl_iterator<ObjCIvarDecl> ivar_iterator*/
//  public final class ivar_iterator extends specific_decl_iterator<ObjCIvarDecl>{ };
  /*typedef llvm::iterator_range<specific_decl_iterator<ObjCIvarDecl> > ivar_range*/
//  public final class ivar_range extends iterator_range<ObjCIvarDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::ivars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2601,
   FQN="clang::ObjCImplementationDecl::ivars", NM="_ZNK5clang22ObjCImplementationDecl5ivarsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl5ivarsEv")
  //</editor-fold>
  public iterator_range<ObjCIvarDecl /*P*/ > ivars() /*const*/ {
    return new iterator_range<ObjCIvarDecl /*P*/ >(ivar_begin(), ivar_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::ivar_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2602,
   FQN="clang::ObjCImplementationDecl::ivar_begin", NM="_ZNK5clang22ObjCImplementationDecl10ivar_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl10ivar_beginEv")
  //</editor-fold>
  public specific_decl_iterator<ObjCIvarDecl> ivar_begin() /*const*/ {
    return new specific_decl_iterator<ObjCIvarDecl>(ObjCIvarDecl.class, decls_begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::ivar_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2605,
   FQN="clang::ObjCImplementationDecl::ivar_end", NM="_ZNK5clang22ObjCImplementationDecl8ivar_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl8ivar_endEv")
  //</editor-fold>
  public specific_decl_iterator<ObjCIvarDecl> ivar_end() /*const*/ {
    return new specific_decl_iterator<ObjCIvarDecl>(ObjCIvarDecl.class, decls_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::ivar_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2608,
   FQN="clang::ObjCImplementationDecl::ivar_size", NM="_ZNK5clang22ObjCImplementationDecl9ivar_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl9ivar_sizeEv")
  //</editor-fold>
  public /*uint*/int ivar_size() /*const*/ {
    return std.distance(ivar_begin(), ivar_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::ivar_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2611,
   FQN="clang::ObjCImplementationDecl::ivar_empty", NM="_ZNK5clang22ObjCImplementationDecl10ivar_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang22ObjCImplementationDecl10ivar_emptyEv")
  //</editor-fold>
  public boolean ivar_empty() /*const*/ {
    return $eq_specific_decl_iterator$SpecificDecl$C(ivar_begin(), ivar_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2615,
   FQN="clang::ObjCImplementationDecl::classof", NM="_ZN5clang22ObjCImplementationDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2616,
   FQN="clang::ObjCImplementationDecl::classofKind", NM="_ZN5clang22ObjCImplementationDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ObjCImplementation;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplementationDecl::~ObjCImplementationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2461,
   FQN="clang::ObjCImplementationDecl::~ObjCImplementationDecl", NM="_ZN5clang22ObjCImplementationDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang22ObjCImplementationDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "SuperClass=" + SuperClass // NOI18N
              + ", SuperLoc=" + SuperLoc // NOI18N
              + ", IvarLBraceLoc=" + IvarLBraceLoc // NOI18N
              + ", IvarRBraceLoc=" + IvarRBraceLoc // NOI18N
              + ", IvarInitializers=" + IvarInitializers // NOI18N
              + ", NumIvarInitializers=" + NumIvarInitializers // NOI18N
              + ", HasNonZeroConstructors=" + HasNonZeroConstructors // NOI18N
              + ", HasDestructors=" + HasDestructors // NOI18N
              + super.toString(); // NOI18N
  }
}
