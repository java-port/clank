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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// ObjCPropertyRefExpr - A dot-syntax expression to access an ObjC
/// property.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 539,
 FQN="clang::ObjCPropertyRefExpr", NM="_ZN5clang19ObjCPropertyRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExprE")
//</editor-fold>
public class ObjCPropertyRefExpr extends /*public*/ Expr {
/*private:*/
  /// If the bool is true, this is an implicit property reference; the
  /// pointer is an (optional) ObjCMethodDecl and Setter may be set.
  /// if the bool is false, this is an explicit property reference;
  /// the pointer is an ObjCPropertyDecl and Setter is always null.
  private PointerBoolPair<NamedDecl /*P*/ > PropertyOrGetter;
  
  /// \brief Indicates whether the property reference will result in a message
  /// to the getter, the setter, or both.
  /// This applies to both implicit and explicit property references.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::MethodRefFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 550,
   FQN="clang::ObjCPropertyRefExpr::MethodRefFlags", NM="_ZN5clang19ObjCPropertyRefExpr14MethodRefFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr14MethodRefFlagsE")
  //</editor-fold>
  private static final class/*enum*/ MethodRefFlags {
    public static final /*uint*/int MethodRef_None = 0;
    public static final /*uint*/int MethodRef_Getter = 0x1;
    public static final /*uint*/int MethodRef_Setter = 0x2;
  };
  
  /// \brief Contains the Setter method pointer and MethodRefFlags bit flags.
  /*friend*/public PointerUInt2Pair<ObjCMethodDecl /*P*/ > SetterAndMethodRefFlags;
  
  // FIXME: Maybe we should store the property identifier here,
  // because it's not rederivable from the other data when there's an
  // implicit property with no getter (because the 'foo' -> 'setFoo:'
  // transformation is lossy on the first character).
  private SourceLocation IdLoc;
  
  /// \brief When the receiver in property access is 'super', this is
  /// the location of the 'super' keyword.  When it's an interface,
  /// this is that interface.
  private SourceLocation ReceiverLoc;
  private PointerUnion3<Stmt /*P*/ , /*const*/ Type /*P*/ , ObjCInterfaceDecl /*P*/ > Receiver;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::ObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 573,
   FQN="clang::ObjCPropertyRefExpr::ObjCPropertyRefExpr", NM="_ZN5clang19ObjCPropertyRefExprC1EPNS_16ObjCPropertyDeclENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExprC1EPNS_16ObjCPropertyDeclENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationEPNS_4ExprE")
  //</editor-fold>
  public ObjCPropertyRefExpr(ObjCPropertyDecl /*P*/ PD, QualType t, 
      ExprValueKind VK, ExprObjectKind OK, 
      SourceLocation l, Expr /*P*/ base) {
    // : Expr(ObjCPropertyRefExprClass, t, VK, OK, /*TypeDependent=*/ false, base->isValueDependent(), base->isInstantiationDependent(), base->containsUnexpandedParameterPack()), PropertyOrGetter(PD, false), SetterAndMethodRefFlags(), IdLoc(l), ReceiverLoc(), Receiver(base) 
    //START JInit
    super(StmtClass.ObjCPropertyRefExprClass, new QualType(t), VK, OK, 
        false, base.isValueDependent(), 
        base.isInstantiationDependent(), 
        base.containsUnexpandedParameterPack());
    this.PropertyOrGetter = new PointerBoolPair<NamedDecl /*P*/ >(PD, false);
    this.SetterAndMethodRefFlags = new PointerUInt2Pair<ObjCMethodDecl /*P*/ >();
    this.IdLoc = new SourceLocation(l);
    this.ReceiverLoc = new SourceLocation();
    this.Receiver = new PointerUnion3<Stmt /*P*/ , /*const*/ Type /*P*/ , ObjCInterfaceDecl /*P*/ >(JD$T.INSTANCE, Stmt /*P*/.class, base);
    //END JInit
    assert (t.$arrow().isSpecificPlaceholderType(BuiltinType.Kind.PseudoObject.getValue()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::ObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 585,
   FQN="clang::ObjCPropertyRefExpr::ObjCPropertyRefExpr", NM="_ZN5clang19ObjCPropertyRefExprC1EPNS_16ObjCPropertyDeclENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationES6_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExprC1EPNS_16ObjCPropertyDeclENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationES6_S3_")
  //</editor-fold>
  public ObjCPropertyRefExpr(ObjCPropertyDecl /*P*/ PD, QualType t, 
      ExprValueKind VK, ExprObjectKind OK, 
      SourceLocation l, SourceLocation sl, QualType st) {
    // : Expr(ObjCPropertyRefExprClass, t, VK, OK, /*TypeDependent=*/ false, false, st->isInstantiationDependentType(), st->containsUnexpandedParameterPack()), PropertyOrGetter(PD, false), SetterAndMethodRefFlags(), IdLoc(l), ReceiverLoc(sl), Receiver(st.getTypePtr()) 
    //START JInit
    super(StmtClass.ObjCPropertyRefExprClass, new QualType(t), VK, OK, 
        false, false, st.$arrow().isInstantiationDependentType(), 
        st.$arrow().containsUnexpandedParameterPack());
    this.PropertyOrGetter = new PointerBoolPair<NamedDecl /*P*/ >(PD, false);
    this.SetterAndMethodRefFlags = new PointerUInt2Pair<ObjCMethodDecl /*P*/ >();
    this.IdLoc = new SourceLocation(l);
    this.ReceiverLoc = new SourceLocation(sl);
    this.Receiver = new PointerUnion3<Stmt /*P*/ , /*const*/ Type /*P*/ , ObjCInterfaceDecl /*P*/ >(JD$T1.INSTANCE, Type /*P*/.class, st.getTypePtr());
    //END JInit
    assert (t.$arrow().isSpecificPlaceholderType(BuiltinType.Kind.PseudoObject.getValue()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::ObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 596,
   FQN="clang::ObjCPropertyRefExpr::ObjCPropertyRefExpr", NM="_ZN5clang19ObjCPropertyRefExprC1EPNS_14ObjCMethodDeclES2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExprC1EPNS_14ObjCMethodDeclES2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationEPNS_4ExprE")
  //</editor-fold>
  public ObjCPropertyRefExpr(ObjCMethodDecl /*P*/ Getter, ObjCMethodDecl /*P*/ Setter, 
      QualType T, ExprValueKind VK, ExprObjectKind OK, 
      SourceLocation IdLoc, Expr /*P*/ Base) {
    // : Expr(ObjCPropertyRefExprClass, T, VK, OK, false, Base->isValueDependent(), Base->isInstantiationDependent(), Base->containsUnexpandedParameterPack()), PropertyOrGetter(Getter, true), SetterAndMethodRefFlags(Setter, 0), IdLoc(IdLoc), ReceiverLoc(), Receiver(Base) 
    //START JInit
    super(StmtClass.ObjCPropertyRefExprClass, new QualType(T), VK, OK, false, 
        Base.isValueDependent(), Base.isInstantiationDependent(), 
        Base.containsUnexpandedParameterPack());
    this.PropertyOrGetter = new PointerBoolPair<NamedDecl /*P*/ >(Getter, true);
    this.SetterAndMethodRefFlags = new PointerUInt2Pair<ObjCMethodDecl /*P*/ >(Setter, 0);
    this.IdLoc = new SourceLocation(IdLoc);
    this.ReceiverLoc = new SourceLocation();
    this.Receiver = new PointerUnion3<Stmt /*P*/ , /*const*/ Type /*P*/ , ObjCInterfaceDecl /*P*/ >(JD$T.INSTANCE, Stmt /*P*/.class, Base);
    //END JInit
    assert (T.$arrow().isSpecificPlaceholderType(BuiltinType.Kind.PseudoObject.getValue()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::ObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 607,
   FQN="clang::ObjCPropertyRefExpr::ObjCPropertyRefExpr", NM="_ZN5clang19ObjCPropertyRefExprC1EPNS_14ObjCMethodDeclES2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationES6_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExprC1EPNS_14ObjCMethodDeclES2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationES6_S3_")
  //</editor-fold>
  public ObjCPropertyRefExpr(ObjCMethodDecl /*P*/ Getter, ObjCMethodDecl /*P*/ Setter, 
      QualType T, ExprValueKind VK, ExprObjectKind OK, 
      SourceLocation IdLoc, 
      SourceLocation SuperLoc, QualType SuperTy) {
    // : Expr(ObjCPropertyRefExprClass, T, VK, OK, false, false, false, false), PropertyOrGetter(Getter, true), SetterAndMethodRefFlags(Setter, 0), IdLoc(IdLoc), ReceiverLoc(SuperLoc), Receiver(SuperTy.getTypePtr()) 
    //START JInit
    super(StmtClass.ObjCPropertyRefExprClass, new QualType(T), VK, OK, false, false, false, false);
    this.PropertyOrGetter = new PointerBoolPair<NamedDecl /*P*/ >(Getter, true);
    this.SetterAndMethodRefFlags = new PointerUInt2Pair<ObjCMethodDecl /*P*/ >(Setter, 0);
    this.IdLoc = new SourceLocation(IdLoc);
    this.ReceiverLoc = new SourceLocation(SuperLoc);
    this.Receiver = new PointerUnion3<Stmt /*P*/ , /*const*/ Type /*P*/ , ObjCInterfaceDecl /*P*/ >(JD$T1.INSTANCE, Type /*P*/.class, SuperTy.getTypePtr());
    //END JInit
    assert (T.$arrow().isSpecificPlaceholderType(BuiltinType.Kind.PseudoObject.getValue()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::ObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 617,
   FQN="clang::ObjCPropertyRefExpr::ObjCPropertyRefExpr", NM="_ZN5clang19ObjCPropertyRefExprC1EPNS_14ObjCMethodDeclES2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationES6_PNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExprC1EPNS_14ObjCMethodDeclES2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationES6_PNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public ObjCPropertyRefExpr(ObjCMethodDecl /*P*/ Getter, ObjCMethodDecl /*P*/ Setter, 
      QualType T, ExprValueKind VK, ExprObjectKind OK, 
      SourceLocation IdLoc, 
      SourceLocation ReceiverLoc, ObjCInterfaceDecl /*P*/ Receiver) {
    // : Expr(ObjCPropertyRefExprClass, T, VK, OK, false, false, false, false), PropertyOrGetter(Getter, true), SetterAndMethodRefFlags(Setter, 0), IdLoc(IdLoc), ReceiverLoc(ReceiverLoc), Receiver(Receiver) 
    //START JInit
    super(StmtClass.ObjCPropertyRefExprClass, new QualType(T), VK, OK, false, false, false, false);
    this.PropertyOrGetter = new PointerBoolPair<NamedDecl /*P*/ >(Getter, true);
    this.SetterAndMethodRefFlags = new PointerUInt2Pair<ObjCMethodDecl /*P*/ >(Setter, 0);
    this.IdLoc = new SourceLocation(IdLoc);
    this.ReceiverLoc = new SourceLocation(ReceiverLoc);
    this.Receiver = new PointerUnion3<Stmt /*P*/ , /*const*/ Type /*P*/ , ObjCInterfaceDecl /*P*/ >(JD$T2.INSTANCE, ObjCInterfaceDecl /*P*/.class, Receiver);
    //END JInit
    assert (T.$arrow().isSpecificPlaceholderType(BuiltinType.Kind.PseudoObject.getValue()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::ObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 627,
   FQN="clang::ObjCPropertyRefExpr::ObjCPropertyRefExpr", NM="_ZN5clang19ObjCPropertyRefExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCPropertyRefExpr(EmptyShell Empty) {
    // : Expr(ObjCPropertyRefExprClass, Empty), PropertyOrGetter(), SetterAndMethodRefFlags(), IdLoc(), ReceiverLoc(), Receiver() 
    //START JInit
    super(StmtClass.ObjCPropertyRefExprClass, new EmptyShell(Empty));
    this.PropertyOrGetter = new PointerBoolPair<NamedDecl /*P*/ >();
    this.SetterAndMethodRefFlags = new PointerUInt2Pair<ObjCMethodDecl /*P*/ >();
    this.IdLoc = new SourceLocation();
    this.ReceiverLoc = new SourceLocation();
    this.Receiver = new PointerUnion3<Stmt /*P*/ , /*const*/ Type /*P*/ , ObjCInterfaceDecl /*P*/ >(Stmt /*P*/.class);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::isImplicitProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 630,
   FQN="clang::ObjCPropertyRefExpr::isImplicitProperty", NM="_ZNK5clang19ObjCPropertyRefExpr18isImplicitPropertyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr18isImplicitPropertyEv")
  //</editor-fold>
  public boolean isImplicitProperty() /*const*/ {
    return PropertyOrGetter.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::isExplicitProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 631,
   FQN="clang::ObjCPropertyRefExpr::isExplicitProperty", NM="_ZNK5clang19ObjCPropertyRefExpr18isExplicitPropertyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr18isExplicitPropertyEv")
  //</editor-fold>
  public boolean isExplicitProperty() /*const*/ {
    return !PropertyOrGetter.getInt();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getExplicitProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 633,
   FQN="clang::ObjCPropertyRefExpr::getExplicitProperty", NM="_ZNK5clang19ObjCPropertyRefExpr19getExplicitPropertyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr19getExplicitPropertyEv")
  //</editor-fold>
  public ObjCPropertyDecl /*P*/ getExplicitProperty() /*const*/ {
    assert (!isImplicitProperty());
    return cast_ObjCPropertyDecl(PropertyOrGetter.getPointer());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getImplicitPropertyGetter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 638,
   FQN="clang::ObjCPropertyRefExpr::getImplicitPropertyGetter", NM="_ZNK5clang19ObjCPropertyRefExpr25getImplicitPropertyGetterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr25getImplicitPropertyGetterEv")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getImplicitPropertyGetter() /*const*/ {
    assert (isImplicitProperty());
    return cast_or_null_ObjCMethodDecl(PropertyOrGetter.getPointer());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getImplicitPropertySetter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 643,
   FQN="clang::ObjCPropertyRefExpr::getImplicitPropertySetter", NM="_ZNK5clang19ObjCPropertyRefExpr25getImplicitPropertySetterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr25getImplicitPropertySetterEv")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getImplicitPropertySetter() /*const*/ {
    assert (isImplicitProperty());
    return SetterAndMethodRefFlags.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getGetterSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 648,
   FQN="clang::ObjCPropertyRefExpr::getGetterSelector", NM="_ZNK5clang19ObjCPropertyRefExpr17getGetterSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr17getGetterSelectorEv")
  //</editor-fold>
  public Selector getGetterSelector() /*const*/ {
    if (isImplicitProperty()) {
      return getImplicitPropertyGetter().getSelector();
    }
    return getExplicitProperty().getGetterName();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getSetterSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 654,
   FQN="clang::ObjCPropertyRefExpr::getSetterSelector", NM="_ZNK5clang19ObjCPropertyRefExpr17getSetterSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr17getSetterSelectorEv")
  //</editor-fold>
  public Selector getSetterSelector() /*const*/ {
    if (isImplicitProperty()) {
      return getImplicitPropertySetter().getSelector();
    }
    return getExplicitProperty().getSetterName();
  }

  
  /// \brief True if the property reference will result in a message to the
  /// getter.
  /// This applies to both implicit and explicit property references.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::isMessagingGetter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 663,
   FQN="clang::ObjCPropertyRefExpr::isMessagingGetter", NM="_ZNK5clang19ObjCPropertyRefExpr17isMessagingGetterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr17isMessagingGetterEv")
  //</editor-fold>
  public boolean isMessagingGetter() /*const*/ {
    return ((SetterAndMethodRefFlags.getInt() & MethodRefFlags.MethodRef_Getter) != 0);
  }

  
  /// \brief True if the property reference will result in a message to the
  /// setter.
  /// This applies to both implicit and explicit property references.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::isMessagingSetter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 670,
   FQN="clang::ObjCPropertyRefExpr::isMessagingSetter", NM="_ZNK5clang19ObjCPropertyRefExpr17isMessagingSetterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr17isMessagingSetterEv")
  //</editor-fold>
  public boolean isMessagingSetter() /*const*/ {
    return ((SetterAndMethodRefFlags.getInt() & MethodRefFlags.MethodRef_Setter) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::setIsMessagingGetter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 674,
   FQN="clang::ObjCPropertyRefExpr::setIsMessagingGetter", NM="_ZN5clang19ObjCPropertyRefExpr20setIsMessagingGetterEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr20setIsMessagingGetterEb")
  //</editor-fold>
  public void setIsMessagingGetter() {
    setIsMessagingGetter(true);
  }
  public void setIsMessagingGetter(boolean val/*= true*/) {
    setMethodRefFlag(MethodRefFlags.MethodRef_Getter, val);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::setIsMessagingSetter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 678,
   FQN="clang::ObjCPropertyRefExpr::setIsMessagingSetter", NM="_ZN5clang19ObjCPropertyRefExpr20setIsMessagingSetterEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr20setIsMessagingSetterEb")
  //</editor-fold>
  public void setIsMessagingSetter() {
    setIsMessagingSetter(true);
  }
  public void setIsMessagingSetter(boolean val/*= true*/) {
    setMethodRefFlag(MethodRefFlags.MethodRef_Setter, val);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 682,
   FQN="clang::ObjCPropertyRefExpr::getBase", NM="_ZNK5clang19ObjCPropertyRefExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr7getBaseEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getBase$Const() /*const*/ {
    return cast_Expr(Receiver.get(Stmt /*P*/.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 685,
   FQN="clang::ObjCPropertyRefExpr::getBase", NM="_ZN5clang19ObjCPropertyRefExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr7getBaseEv")
  //</editor-fold>
  public Expr /*P*/ getBase() {
    return cast_Expr(Receiver.get(Stmt /*P*/.class));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 689,
   FQN="clang::ObjCPropertyRefExpr::getLocation", NM="_ZNK5clang19ObjCPropertyRefExpr11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(IdLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getReceiverLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 691,
   FQN="clang::ObjCPropertyRefExpr::getReceiverLocation", NM="_ZNK5clang19ObjCPropertyRefExpr19getReceiverLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr19getReceiverLocationEv")
  //</editor-fold>
  public SourceLocation getReceiverLocation() /*const*/ {
    return new SourceLocation(ReceiverLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getSuperReceiverType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 692,
   FQN="clang::ObjCPropertyRefExpr::getSuperReceiverType", NM="_ZNK5clang19ObjCPropertyRefExpr20getSuperReceiverTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr20getSuperReceiverTypeEv")
  //</editor-fold>
  public QualType getSuperReceiverType() /*const*/ {
    return new QualType(Receiver.get(/*const*/ Type /*P*/.class), 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getClassReceiver">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 696,
   FQN="clang::ObjCPropertyRefExpr::getClassReceiver", NM="_ZNK5clang19ObjCPropertyRefExpr16getClassReceiverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr16getClassReceiverEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getClassReceiver() /*const*/ {
    return Receiver.get(ObjCInterfaceDecl /*P*/.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::isObjectReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 699,
   FQN="clang::ObjCPropertyRefExpr::isObjectReceiver", NM="_ZNK5clang19ObjCPropertyRefExpr16isObjectReceiverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr16isObjectReceiverEv")
  //</editor-fold>
  public boolean isObjectReceiver() /*const*/ {
    return (Receiver.is(Stmt /*P*/.class) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::isSuperReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 700,
   FQN="clang::ObjCPropertyRefExpr::isSuperReceiver", NM="_ZNK5clang19ObjCPropertyRefExpr15isSuperReceiverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr15isSuperReceiverEv")
  //</editor-fold>
  public boolean isSuperReceiver() /*const*/ {
    return (Receiver.is(/*const*/ Type /*P*/.class) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::isClassReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 701,
   FQN="clang::ObjCPropertyRefExpr::isClassReceiver", NM="_ZNK5clang19ObjCPropertyRefExpr15isClassReceiverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr15isClassReceiverEv")
  //</editor-fold>
  public boolean isClassReceiver() /*const*/ {
    return (Receiver.is(ObjCInterfaceDecl /*P*/.class) != 0);
  }

  
  /// Determine the type of the base, regardless of the kind of receiver.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getReceiverType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 107,
   FQN="clang::ObjCPropertyRefExpr::getReceiverType", NM="_ZNK5clang19ObjCPropertyRefExpr15getReceiverTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr15getReceiverTypeERKNS_10ASTContextE")
  //</editor-fold>
  public QualType getReceiverType(final /*const*/ ASTContext /*&*/ ctx) /*const*/ {
    if (isClassReceiver()) {
      return ctx.getObjCInterfaceType(getClassReceiver());
    }
    if (isSuperReceiver()) {
      return getSuperReceiverType();
    }
    
    return getBase$Const().getType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 706,
   FQN="clang::ObjCPropertyRefExpr::getLocStart", NM="_ZNK5clang19ObjCPropertyRefExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return isObjectReceiver() ? getBase$Const().getLocStart() : getReceiverLocation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 709,
   FQN="clang::ObjCPropertyRefExpr::getLocEnd", NM="_ZNK5clang19ObjCPropertyRefExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCPropertyRefExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(IdLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 711,
   FQN="clang::ObjCPropertyRefExpr::classof", NM="_ZN5clang19ObjCPropertyRefExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCPropertyRefExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 716,
   FQN="clang::ObjCPropertyRefExpr::children", NM="_ZN5clang19ObjCPropertyRefExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    if ((Receiver.is(Stmt /*P*/.class) != 0)) {
//      type$ptr<Stmt /*P*/ /*P*/> begin = $tryClone(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, /*AddrOf*/Receiver))); // hack!
      type$ptr<Stmt /*P*/ /*P*/> begin = $AddrOf(Receiver.getAddrOfPtr1(Stmt /*P*/.class)); // hack!
      return new iterator_range<Stmt/*P*/>(new StmtIterator(begin), new StmtIterator(begin.$add(1)));
    }
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

/*private:*/
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::setExplicitProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 727,
   FQN="clang::ObjCPropertyRefExpr::setExplicitProperty", NM="_ZN5clang19ObjCPropertyRefExpr19setExplicitPropertyEPNS_16ObjCPropertyDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr19setExplicitPropertyEPNS_16ObjCPropertyDeclEj")
  //</editor-fold>
  /*friend*/public void setExplicitProperty(ObjCPropertyDecl /*P*/ D, /*uint*/int methRefFlags) {
    PropertyOrGetter.setPointer(D);
    PropertyOrGetter.setInt(false);
    SetterAndMethodRefFlags.setPointer((ObjCMethodDecl /*P*/ )null);
    SetterAndMethodRefFlags.setInt(methRefFlags);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::setImplicitProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 733,
   FQN="clang::ObjCPropertyRefExpr::setImplicitProperty", NM="_ZN5clang19ObjCPropertyRefExpr19setImplicitPropertyEPNS_14ObjCMethodDeclES2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr19setImplicitPropertyEPNS_14ObjCMethodDeclES2_j")
  //</editor-fold>
  /*friend*/public void setImplicitProperty(ObjCMethodDecl /*P*/ Getter, ObjCMethodDecl /*P*/ Setter, 
                     /*uint*/int methRefFlags) {
    PropertyOrGetter.setPointer(Getter);
    PropertyOrGetter.setInt(true);
    SetterAndMethodRefFlags.setPointer(Setter);
    SetterAndMethodRefFlags.setInt(methRefFlags);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::setBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 740,
   FQN="clang::ObjCPropertyRefExpr::setBase", NM="_ZN5clang19ObjCPropertyRefExpr7setBaseEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr7setBaseEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setBase(Expr /*P*/ Base) {
    Receiver.$assign_T$C$R(Stmt /*P*/.class, Base);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::setSuperReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 741,
   FQN="clang::ObjCPropertyRefExpr::setSuperReceiver", NM="_ZN5clang19ObjCPropertyRefExpr16setSuperReceiverENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr16setSuperReceiverENS_8QualTypeE")
  //</editor-fold>
  /*friend*/public void setSuperReceiver(QualType T) {
    Receiver.$assign_T1$C$R(Type /*P*/.class, T.getTypePtr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::setClassReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 742,
   FQN="clang::ObjCPropertyRefExpr::setClassReceiver", NM="_ZN5clang19ObjCPropertyRefExpr16setClassReceiverEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr16setClassReceiverEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  /*friend*/public void setClassReceiver(ObjCInterfaceDecl /*P*/ D) {
    Receiver.$assign_T2$C$R(ObjCInterfaceDecl /*P*/.class, D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 744,
   FQN="clang::ObjCPropertyRefExpr::setLocation", NM="_ZN5clang19ObjCPropertyRefExpr11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr11setLocationENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setLocation(SourceLocation L) {
    IdLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::setReceiverLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 745,
   FQN="clang::ObjCPropertyRefExpr::setReceiverLocation", NM="_ZN5clang19ObjCPropertyRefExpr19setReceiverLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr19setReceiverLocationENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setReceiverLocation(SourceLocation Loc) {
    ReceiverLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyRefExpr::setMethodRefFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 747,
   FQN="clang::ObjCPropertyRefExpr::setMethodRefFlag", NM="_ZN5clang19ObjCPropertyRefExpr16setMethodRefFlagENS0_14MethodRefFlagsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCPropertyRefExpr16setMethodRefFlagENS0_14MethodRefFlagsEb")
  //</editor-fold>
  private void setMethodRefFlag(/*MethodRefFlags*//*uint*/int flag, boolean val) {
    /*uint*/int f = SetterAndMethodRefFlags.getInt();
    if (val) {
      f |= flag;
    } else {
      f &= ~flag;
    }
    SetterAndMethodRefFlags.setInt(f);
  }

  
  @Override public String toString() {
    return "" + "PropertyOrGetter=" + PropertyOrGetter // NOI18N
              + ", SetterAndMethodRefFlags=" + SetterAndMethodRefFlags // NOI18N
              + ", IdLoc=" + IdLoc // NOI18N
              + ", ReceiverLoc=" + ReceiverLoc // NOI18N
              + ", Receiver=" + Receiver // NOI18N
              + super.toString(); // NOI18N
  }
}
