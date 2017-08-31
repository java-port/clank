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
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.ast.AstClangGlobals.*;
import org.llvm.support.TrailingObjects.*;


/// \brief An expression that sends a message to the given Objective-C
/// object or class.
///
/// The following contains two message send expressions:
///
/// \code
///   [[NSString alloc] initWithString:@"Hello"]
/// \endcode
///
/// The innermost message send invokes the "alloc" class method on the
/// NSString class, while the outermost message send invokes the
/// "initWithString" instance method on the object returned from
/// NSString's "alloc". In all, an Objective-C message send can take
/// on four different (although related) forms:
///
///   1. Send to an object instance.
///   2. Send to a class.
///   3. Send to the superclass instance of the current class.
///   4. Send to the superclass of the current class.
///
/// All four kinds of message sends are modeled by the ObjCMessageExpr
/// class, and can be distinguished via \c getReceiverKind(). Example:
///
/// The "void *" trailing objects are actually ONE void * (the
/// receiver pointer), and NumArgs Expr *. But due to the
/// implementation of children(), these must be together contiguously.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 860,
 FQN="clang::ObjCMessageExpr", NM="_ZN5clang15ObjCMessageExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExprE")
//</editor-fold>
public final class ObjCMessageExpr extends /*public*/ Expr implements /*private*/ TrailingObjects$VoidPtr$T<ObjCMessageExpr/*, void P*/, SourceLocation> {
  /// \brief Stores either the selector that this message is sending
  /// to (when \c HasMethod is zero) or an \c ObjCMethodDecl pointer
  /// referring to the method that we type-checked against.
  private Object/*uintptr_t*/ SelectorOrMethod;
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 868,
   FQN="clang::ObjCMessageExpr::(anonymous)", NM="_ZN5clang15ObjCMessageExprE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExprE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumArgsBitWidth = 16;
  /*}*/;
  
  /// \brief The number of arguments in the message send, not
  /// including the receiver.
  private /*JCHAR unsigned int*/ char NumArgs /*: NumArgsBitWidth*/;
  
  /// \brief The kind of message send this is, which is one of the
  /// ReceiverKind values.
  ///
  /// We pad this out to a byte to avoid excessive masking and shifting.
  private /*JBYTE unsigned int*/ byte Kind /*: 8*/;
  
  /// \brief Whether we have an actual method prototype in \c
  /// SelectorOrMethod.
  ///
  /// When non-zero, we have a method declaration; otherwise, we just
  /// have a selector.
  private /*JBIT unsigned int*/ boolean HasMethod /*: 1*/;
  
  /// \brief Whether this message send is a "delegate init call",
  /// i.e. a call of an init method on self from within an init method.
  private /*JBIT unsigned int*/ boolean IsDelegateInitCall /*: 1*/;
  
  /// \brief Whether this message send was implicitly generated by
  /// the implementation rather than explicitly written by the user.
  /*friend*/public /*JBIT unsigned int*/ boolean IsImplicit /*: 1*/;
  
  /// \brief Whether the locations of the selector identifiers are in a
  /// "standard" position, a enum SelectorLocationsKind.
  /*friend*/public /*JBYTE unsigned int*/ byte SelLocsKind /*: 2*/;
  
  /// \brief When the message expression is a send to 'super', this is
  /// the location of the 'super' keyword.
  private SourceLocation SuperLoc;
  
  /// \brief The source locations of the open and close square
  /// brackets ('[' and ']', respectively).
  /*friend*/public SourceLocation LBracLoc;
  /*friend*/public SourceLocation RBracLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 907,
   FQN="clang::ObjCMessageExpr::numTrailingObjects", NM="_ZNK5clang15ObjCMessageExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPvEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPvEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects(OverloadToken<Object/*void P*/ > $Prm0) /*const*/ {
    return NumArgs + $int2uint_16bits(1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::setNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 909,
   FQN="clang::ObjCMessageExpr::setNumArgs", NM="_ZN5clang15ObjCMessageExpr10setNumArgsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr10setNumArgsEj")
  //</editor-fold>
  private void setNumArgs(/*uint*/int Num) {
    assert ((Num >>> NumArgsBitWidth) == 0) : "Num of args is out of range!";
    NumArgs = $uint2uint_16bits(Num);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::ObjCMessageExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 914,
   FQN="clang::ObjCMessageExpr::ObjCMessageExpr", NM="_ZN5clang15ObjCMessageExprC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExprC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private ObjCMessageExpr(EmptyShell Empty, /*uint*/int NumArgs) {
    // : Expr(ObjCMessageExprClass, Empty), TrailingObjects<ObjCMessageExpr, void * , SourceLocation>(), SelectorOrMethod(0), Kind(0), HasMethod(0), IsDelegateInitCall(0), IsImplicit(0), SelLocsKind(0), SuperLoc(), LBracLoc(), RBracLoc() 
    //START JInit
    super(StmtClass.ObjCMessageExprClass, new EmptyShell(Empty));
    $TrailingObjects();
    this.SelectorOrMethod = 0;
    this.Kind = $uint2uint_8bits(0);
    this.HasMethod = false;
    this.IsDelegateInitCall = false;
    this.IsImplicit = false;
    this.SelLocsKind = $uint2uint_2bits(0);
    this.SuperLoc = new SourceLocation();
    this.LBracLoc = new SourceLocation();
    this.RBracLoc = new SourceLocation();
    //END JInit
    setNumArgs(NumArgs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::ObjCMessageExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 117,
   FQN="clang::ObjCMessageExpr::ObjCMessageExpr", NM="_ZN5clang15ObjCMessageExprC1ENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationES3_bS1_NS_8SelectorEN4llvm8ArrayRefIS3_EENS_21SelectorLocationsKindEPNS_14ObjCMethodDeclENS6_IPNS_4ExprEEES3_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExprC1ENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationES3_bS1_NS_8SelectorEN4llvm8ArrayRefIS3_EENS_21SelectorLocationsKindEPNS_14ObjCMethodDeclENS6_IPNS_4ExprEEES3_b")
  //</editor-fold>
  private ObjCMessageExpr(QualType T, ExprValueKind VK, 
      SourceLocation LBracLoc, 
      SourceLocation SuperLoc, boolean IsInstanceSuper, 
      QualType SuperType, Selector Sel, 
      ArrayRef<SourceLocation> SelLocs, 
      SelectorLocationsKind SelLocsK, 
      ObjCMethodDecl /*P*/ Method, ArrayRef<Expr /*P*/ > Args, 
      SourceLocation RBracLoc, boolean isImplicit) {
    // : Expr(ObjCMessageExprClass, T, VK, OK_Ordinary, /*TypeDependent=*/ false, /*ValueDependent=*/ false, /*InstantiationDependent=*/ false, /*ContainsUnexpandedParameterPack=*/ false), TrailingObjects<ObjCMessageExpr, void * , SourceLocation>(), SelectorOrMethod(reinterpret_cast<uintptr_t>(Method ? Method : Sel.getAsOpaquePtr())), Kind(IsInstanceSuper ? SuperInstance : SuperClass), HasMethod(Method != null), IsDelegateInitCall(false), IsImplicit(isImplicit), SuperLoc(SuperLoc), LBracLoc(LBracLoc), RBracLoc(RBracLoc) 
    //START JInit
    super(StmtClass.ObjCMessageExprClass, new QualType(T), VK, ExprObjectKind.OK_Ordinary, 
        false, false, 
        false, 
        false);
    this.$TrailingObjects();
    this.SelectorOrMethod = reinterpret_cast_Object/*uintptr_t*/((Method != null) ? Method : Sel.getAsOpaquePtr());
    this.Kind = $uint2uint_8bits(IsInstanceSuper ? ReceiverKind.SuperInstance.getValue() : ReceiverKind.SuperClass.getValue());
    this.HasMethod = Method != null;
    this.IsDelegateInitCall = false;
    this.IsImplicit = isImplicit;
    this.SuperLoc = new SourceLocation(SuperLoc);
    this.LBracLoc = new SourceLocation(LBracLoc);
    this.RBracLoc = new SourceLocation(RBracLoc);
    //END JInit
    initArgsAndSelLocs(new ArrayRef<Expr /*P*/ >(Args), new ArrayRef<SourceLocation>(SelLocs), SelLocsK);
    setReceiverPointer(SuperType.getAsOpaquePtr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::ObjCMessageExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 139,
   FQN="clang::ObjCMessageExpr::ObjCMessageExpr", NM="_ZN5clang15ObjCMessageExprC1ENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPNS_14TypeSourceInfoENS_8SelectorEN4llvm8ArrayRefIS3_EENS_21SelectorLocationsKindEPNS_14ObjCMethodDeclENS8_IPNS_4ExprEEES3_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExprC1ENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPNS_14TypeSourceInfoENS_8SelectorEN4llvm8ArrayRefIS3_EENS_21SelectorLocationsKindEPNS_14ObjCMethodDeclENS8_IPNS_4ExprEEES3_b")
  //</editor-fold>
  private ObjCMessageExpr(JD$QualType_ExprValueKind_SourceLocation_TypeSourceInfo$P_Selector_ArrayRef$SourceLocation_SelectorLocationsKind_ObjCMethodDecl$P_ArrayRef$Expr$P_SourceLocation_Bool _dparam, QualType T, ExprValueKind VK, 
      SourceLocation LBracLoc, 
      TypeSourceInfo /*P*/ Receiver, Selector Sel, 
      ArrayRef<SourceLocation> SelLocs, 
      SelectorLocationsKind SelLocsK, 
      ObjCMethodDecl /*P*/ Method, ArrayRef<Expr /*P*/ > Args, 
      SourceLocation RBracLoc, boolean isImplicit) {
    // : Expr(ObjCMessageExprClass, T, VK, OK_Ordinary, T->isDependentType(), T->isDependentType(), T->isInstantiationDependentType(), T->containsUnexpandedParameterPack()), TrailingObjects<ObjCMessageExpr, void * , SourceLocation>(), SelectorOrMethod(reinterpret_cast<uintptr_t>(Method ? Method : Sel.getAsOpaquePtr())), Kind(Class), HasMethod(Method != null), IsDelegateInitCall(false), IsImplicit(isImplicit), SuperLoc(), LBracLoc(LBracLoc), RBracLoc(RBracLoc) 
    //START JInit
    super(StmtClass.ObjCMessageExprClass, new QualType(T), VK, ExprObjectKind.OK_Ordinary, T.$arrow().isDependentType(), 
        T.$arrow().isDependentType(), T.$arrow().isInstantiationDependentType(), 
        T.$arrow().containsUnexpandedParameterPack());
    $TrailingObjects();
    this.SelectorOrMethod = reinterpret_cast_Object/*uintptr_t*/((Method != null) ? Method : Sel.getAsOpaquePtr());
    this.Kind = $uint2uint_8bits(ReceiverKind.Class.getValue());
    this.HasMethod = Method != null;
    this.IsDelegateInitCall = false;
    this.IsImplicit = isImplicit;
    this.SuperLoc = new SourceLocation();
    this.LBracLoc = new SourceLocation(LBracLoc);
    this.RBracLoc = new SourceLocation(RBracLoc);
    //END JInit
    initArgsAndSelLocs(new ArrayRef<Expr /*P*/ >(Args), new ArrayRef<SourceLocation>(SelLocs), SelLocsK);
    setReceiverPointer(Receiver);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::ObjCMessageExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 157,
   FQN="clang::ObjCMessageExpr::ObjCMessageExpr", NM="_ZN5clang15ObjCMessageExprC1ENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPNS_4ExprENS_8SelectorEN4llvm8ArrayRefIS3_EENS_21SelectorLocationsKindEPNS_14ObjCMethodDeclENS8_IS5_EES3_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExprC1ENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPNS_4ExprENS_8SelectorEN4llvm8ArrayRefIS3_EENS_21SelectorLocationsKindEPNS_14ObjCMethodDeclENS8_IS5_EES3_b")
  //</editor-fold>
  private ObjCMessageExpr(JD$QualType_ExprValueKind_SourceLocation_Expr$P_Selector_ArrayRef$SourceLocation_SelectorLocationsKind_ObjCMethodDecl$P_ArrayRef$Expr$P_SourceLocation_Bool _dparam, QualType T, ExprValueKind VK, 
      SourceLocation LBracLoc, Expr /*P*/ Receiver, 
      Selector Sel, ArrayRef<SourceLocation> SelLocs, 
      SelectorLocationsKind SelLocsK, 
      ObjCMethodDecl /*P*/ Method, ArrayRef<Expr /*P*/ > Args, 
      SourceLocation RBracLoc, boolean isImplicit) {
    // : Expr(ObjCMessageExprClass, T, VK, OK_Ordinary, Receiver->isTypeDependent(), Receiver->isTypeDependent(), Receiver->isInstantiationDependent(), Receiver->containsUnexpandedParameterPack()), TrailingObjects<ObjCMessageExpr, void * , SourceLocation>(), SelectorOrMethod(reinterpret_cast<uintptr_t>(Method ? Method : Sel.getAsOpaquePtr())), Kind(Instance), HasMethod(Method != null), IsDelegateInitCall(false), IsImplicit(isImplicit), SuperLoc(), LBracLoc(LBracLoc), RBracLoc(RBracLoc) 
    //START JInit
    super(StmtClass.ObjCMessageExprClass, new QualType(T), VK, ExprObjectKind.OK_Ordinary, 
        Receiver.isTypeDependent(), Receiver.isTypeDependent(), 
        Receiver.isInstantiationDependent(), 
        Receiver.containsUnexpandedParameterPack());
    $TrailingObjects();
    this.SelectorOrMethod = reinterpret_cast_Object/*uintptr_t*/((Method != null) ? Method : Sel.getAsOpaquePtr());
    this.Kind = $uint2uint_8bits(ReceiverKind.Instance.getValue());
    this.HasMethod = Method != null;
    this.IsDelegateInitCall = false;
    this.IsImplicit = isImplicit;
    this.SuperLoc = new SourceLocation();
    this.LBracLoc = new SourceLocation(LBracLoc);
    this.RBracLoc = new SourceLocation(RBracLoc);
    //END JInit
    initArgsAndSelLocs(new ArrayRef<Expr /*P*/ >(Args), new ArrayRef<SourceLocation>(SelLocs), SelLocsK);
    setReceiverPointer(Receiver);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::initArgsAndSelLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 175,
   FQN="clang::ObjCMessageExpr::initArgsAndSelLocs", NM="_ZN5clang15ObjCMessageExpr18initArgsAndSelLocsEN4llvm8ArrayRefIPNS_4ExprEEENS2_INS_14SourceLocationEEENS_21SelectorLocationsKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr18initArgsAndSelLocsEN4llvm8ArrayRefIPNS_4ExprEEENS2_INS_14SourceLocationEEENS_21SelectorLocationsKindE")
  //</editor-fold>
  private void initArgsAndSelLocs(ArrayRef<Expr /*P*/ > Args, 
                    ArrayRef<SourceLocation> SelLocs, 
                    SelectorLocationsKind SelLocsK) {
    setNumArgs(Args.size());
    type$ptr<Expr /*P*/ /*P*/> MyArgs = $tryClone(getArgs());
    for (/*uint*/int I = 0; I != Args.size(); ++I) {
      if (Args.$at(I).isTypeDependent()) {
        Unnamed_field.ExprBits.TypeDependent = true;
      }
      if (Args.$at(I).isValueDependent()) {
        Unnamed_field.ExprBits.ValueDependent = true;
      }
      if (Args.$at(I).isInstantiationDependent()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (Args.$at(I).containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
      
      MyArgs.$set(I, Args.$at(I));
    }
    
    SelLocsKind = $uint2uint_2bits(SelLocsK.getValue());
    if (!isImplicit()) {
      if (SelLocsK == SelectorLocationsKind.SelLoc_NonStandard) {
        std.copy(SelLocs.begin(), SelLocs.end(), getStoredSelLocs());
      }
    }
  }

  
  /// \brief Retrieve the pointer value of the message receiver.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getReceiverPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 958,
   FQN="clang::ObjCMessageExpr::getReceiverPointer", NM="_ZNK5clang15ObjCMessageExpr18getReceiverPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr18getReceiverPointerEv")
  //</editor-fold>
  private Object/*void P*/ getReceiverPointer() /*const*/ {
    return this.<Object/*void P*/ >getTrailingObjects$VoidPtr$Const().$star();
  }

  
  /// \brief Set the pointer value of the message receiver.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::setReceiverPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 961,
   FQN="clang::ObjCMessageExpr::setReceiverPointer", NM="_ZN5clang15ObjCMessageExpr18setReceiverPointerEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr18setReceiverPointerEPv")
  //</editor-fold>
  private void setReceiverPointer(Object/*void P*/ Value) {
    this.<Object/*void P*/ >getTrailingObjects$VoidPtr().$set(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getSelLocsKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 965,
   FQN="clang::ObjCMessageExpr::getSelLocsKind", NM="_ZNK5clang15ObjCMessageExpr14getSelLocsKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr14getSelLocsKindEv")
  //</editor-fold>
  private SelectorLocationsKind getSelLocsKind() /*const*/ {
    return SelectorLocationsKind.valueOf(SelLocsKind);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::hasStandardSelLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 968,
   FQN="clang::ObjCMessageExpr::hasStandardSelLocs", NM="_ZNK5clang15ObjCMessageExpr18hasStandardSelLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr18hasStandardSelLocsEv")
  //</editor-fold>
  private boolean hasStandardSelLocs() /*const*/ {
    return getSelLocsKind() != SelectorLocationsKind.SelLoc_NonStandard;
  }

  
  /// \brief Get a pointer to the stored selector identifiers locations array.
  /// No locations will be stored if HasStandardSelLocs is true.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getStoredSelLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 974,
   FQN="clang::ObjCMessageExpr::getStoredSelLocs", NM="_ZN5clang15ObjCMessageExpr16getStoredSelLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr16getStoredSelLocsEv")
  //</editor-fold>
  /*friend*/public type$ptr<SourceLocation> /*P*/ getStoredSelLocs() {
    return this.<SourceLocation>getTrailingObjects(SourceLocation.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getStoredSelLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 977,
   FQN="clang::ObjCMessageExpr::getStoredSelLocs", NM="_ZNK5clang15ObjCMessageExpr16getStoredSelLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr16getStoredSelLocsEv")
  //</editor-fold>
  private /*const*/type$ptr<SourceLocation> /*P*/ getStoredSelLocs$Const() /*const*/ {
    return this.<SourceLocation>getTrailingObjects$Const(SourceLocation.class);
  }

  
  /// \brief Get the number of stored selector identifiers locations.
  /// No locations will be stored if HasStandardSelLocs is true.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getNumStoredSelLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 983,
   FQN="clang::ObjCMessageExpr::getNumStoredSelLocs", NM="_ZNK5clang15ObjCMessageExpr19getNumStoredSelLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr19getNumStoredSelLocsEv")
  //</editor-fold>
  /*friend*/public /*uint*/int getNumStoredSelLocs() /*const*/ {
    if (hasStandardSelLocs()) {
      return 0;
    }
    return getNumSelectorLocs();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::alloc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 265,
   FQN="clang::ObjCMessageExpr::alloc", NM="_ZN5clang15ObjCMessageExpr5allocERKNS_10ASTContextEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationENS5_IS9_EENS_8SelectorERNS_21SelectorLocationsKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr5allocERKNS_10ASTContextEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationENS5_IS9_EENS_8SelectorERNS_21SelectorLocationsKindE")
  //</editor-fold>
  private static type$ptr<?>/*ObjCMessageExpr P*/ alloc(final /*const*/ ASTContext /*&*/ C, 
       ArrayRef<Expr /*P*/ > Args, 
       SourceLocation RBraceLoc, 
       ArrayRef<SourceLocation> SelLocs, 
       Selector Sel, 
       final type$ref<SelectorLocationsKind /*&*/> SelLocsK) {
    SelLocsK.$set(hasStandardSelectorLocsExprs(new Selector(Sel), new ArrayRef<SourceLocation>(SelLocs), new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RBraceLoc)));
    /*uint*/int NumStoredSelLocs = (SelLocsK.$deref() == SelectorLocationsKind.SelLoc_NonStandard) ? SelLocs.size() : 0;
    return alloc(C, Args.size(), NumStoredSelLocs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::alloc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 277,
   FQN="clang::ObjCMessageExpr::alloc", NM="_ZN5clang15ObjCMessageExpr5allocERKNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr5allocERKNS_10ASTContextEjj")
  //</editor-fold>
  private static type$ptr<?>/*ObjCMessageExpr P*/ alloc(final /*const*/ ASTContext /*&*/ C, /*uint*/int NumArgs, 
       /*uint*/int NumStoredSelLocs) {
    // JAVA: MEMORY
    int Size = TrailingObjects.<Object/*void P*/ , SourceLocation>totalSizeToAlloc$Same(
            Object.class, SourceLocation.class,
            NumArgs + 1, NumStoredSelLocs);
    type$ptr $Mem = C.Allocate$JavaRef(Size,
            AlignOf.<ObjCMessageExpr/*P*/>Unnamed_enum.Alignment$Java);
    // SourceLocation objects must be allocated
    for (int idx = Size-1, count = NumStoredSelLocs; count > 0; idx--, count--) {
      $Mem.$set(idx, new SourceLocation());
    }
    return $Mem;
  }

/*public:*/
  /// \brief The kind of receiver this message is sending to.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::ReceiverKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1001,
   FQN="clang::ObjCMessageExpr::ReceiverKind", NM="_ZN5clang15ObjCMessageExpr12ReceiverKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr12ReceiverKindE")
  //</editor-fold>
  public enum ReceiverKind implements Native.ComparableLower {
    /// \brief The receiver is a class.
    Class(0),
    /// \brief The receiver is an object instance.
    Instance(Class.getValue() + 1),
    /// \brief The receiver is a superclass.
    SuperClass(Instance.getValue() + 1),
    /// \brief The receiver is the instance of the superclass object.
    SuperInstance(SuperClass.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ReceiverKind valueOf(int val) {
      ReceiverKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ReceiverKind[] VALUES;
      private static final ReceiverKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ReceiverKind kind : ReceiverKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ReceiverKind[min < 0 ? (1-min) : 0];
        VALUES = new ReceiverKind[max >= 0 ? (1+max) : 0];
        for (ReceiverKind kind : ReceiverKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ReceiverKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ReceiverKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ReceiverKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Create a message send to super.
  ///
  /// \param Context The ASTContext in which this expression will be created.
  ///
  /// \param T The result type of this message.
  ///
  /// \param VK The value kind of this message.  A message returning
  /// a l-value or r-value reference will be an l-value or x-value,
  /// respectively.
  ///
  /// \param LBracLoc The location of the open square bracket '['.
  ///
  /// \param SuperLoc The location of the "super" keyword.
  ///
  /// \param IsInstanceSuper Whether this is an instance "super"
  /// message (otherwise, it's a class "super" message).
  ///
  /// \param Sel The selector used to determine which method gets called.
  ///
  /// \param Method The Objective-C method against which this message
  /// send was type-checked. May be NULL.
  ///
  /// \param Args The message send arguments.
  ///
  /// \param RBracLoc The location of the closing square bracket ']'.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 200,
   FQN="clang::ObjCMessageExpr::Create", NM="_ZN5clang15ObjCMessageExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationES6_bS4_NS_8SelectorEN4llvm8ArrayRefIS6_EEPNS_14ObjCMethodDeclENS9_IPNS_4ExprEEES6_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationES6_bS4_NS_8SelectorEN4llvm8ArrayRefIS6_EEPNS_14ObjCMethodDeclENS9_IPNS_4ExprEEES6_b")
  //</editor-fold>
  public static ObjCMessageExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, QualType T, ExprValueKind VK, 
        SourceLocation LBracLoc, SourceLocation SuperLoc, 
        boolean IsInstanceSuper, QualType SuperType, Selector Sel, 
        ArrayRef<SourceLocation> SelLocs, 
        ObjCMethodDecl /*P*/ Method, ArrayRef<Expr /*P*/ > Args, 
        SourceLocation RBracLoc, boolean isImplicit) {
    assert ((!SelLocs.empty() || isImplicit)) : "No selector locs for non-implicit message";
    type$ptr /*P*/ $Mem;
    ObjCMessageExpr /*P*/ _Mem;
    type$ref<SelectorLocationsKind> SelLocsK = create_type$ref(SelectorLocationsKind.valueOf(0));
    if (isImplicit) {
      $Mem = alloc(Context, Args.size(), 0);
    } else {
      $Mem = alloc(Context, new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RBracLoc), new ArrayRef<SourceLocation>(SelLocs), new Selector(Sel), SelLocsK);
    }
    /*NEW_EXPR [Stmt::new]*/_Mem = /*new (Mem)*/ Stmt.$new($Mem, (type$ptr<?> Mem)->{
        return new ObjCMessageExpr(new QualType(T), VK, new SourceLocation(LBracLoc), new SourceLocation(SuperLoc), IsInstanceSuper, 
                new QualType(SuperType), new Selector(Sel), new ArrayRef<SourceLocation>(SelLocs), SelLocsK.$deref(), Method, 
                new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RBracLoc), isImplicit);
     });
    return _Mem;
  }

  
  /// \brief Create a class message send.
  ///
  /// \param Context The ASTContext in which this expression will be created.
  ///
  /// \param T The result type of this message.
  ///
  /// \param VK The value kind of this message.  A message returning
  /// a l-value or r-value reference will be an l-value or x-value,
  /// respectively.
  ///
  /// \param LBracLoc The location of the open square bracket '['.
  ///
  /// \param Receiver The type of the receiver, including
  /// source-location information.
  ///
  /// \param Sel The selector used to determine which method gets called.
  ///
  /// \param Method The Objective-C method against which this message
  /// send was type-checked. May be NULL.
  ///
  /// \param Args The message send arguments.
  ///
  /// \param RBracLoc The location of the closing square bracket ']'.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 220,
   FQN="clang::ObjCMessageExpr::Create", NM="_ZN5clang15ObjCMessageExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPNS_14TypeSourceInfoENS_8SelectorEN4llvm8ArrayRefIS6_EEPNS_14ObjCMethodDeclENSB_IPNS_4ExprEEES6_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPNS_14TypeSourceInfoENS_8SelectorEN4llvm8ArrayRefIS6_EEPNS_14ObjCMethodDeclENSB_IPNS_4ExprEEES6_b")
  //</editor-fold>
  public static ObjCMessageExpr /*P*/ Create1(final /*const*/ ASTContext /*&*/ Context, QualType T, ExprValueKind VK, 
         SourceLocation LBracLoc, TypeSourceInfo /*P*/ Receiver, 
         Selector Sel, ArrayRef<SourceLocation> SelLocs, 
         ObjCMethodDecl /*P*/ Method, ArrayRef<Expr /*P*/ > Args, 
         SourceLocation RBracLoc, boolean isImplicit) {
    assert ((!SelLocs.empty() || isImplicit)) : "No selector locs for non-implicit message";
    type$ptr /*P*/ $Mem;
    ObjCMessageExpr /*P*/ _Mem;
    type$ref<SelectorLocationsKind> SelLocsK = create_type$ref(SelectorLocationsKind.valueOf(0));
    if (isImplicit) {
      $Mem = alloc(Context, Args.size(), 0);
    } else {
      $Mem = alloc(Context, new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RBracLoc), new ArrayRef<SourceLocation>(SelLocs), new Selector(Sel), SelLocsK);
    }
    /*NEW_EXPR [Stmt::new]*/_Mem = /*new (Mem)*/ Stmt.$new($Mem, (type$ptr<?> Mem)->{
        return new ObjCMessageExpr(JD$QualType_ExprValueKind_SourceLocation_TypeSourceInfo$P_Selector_ArrayRef$SourceLocation_SelectorLocationsKind_ObjCMethodDecl$P_ArrayRef$Expr$P_SourceLocation_Bool.INSTANCE, new QualType(T), VK, new SourceLocation(LBracLoc), Receiver, new Selector(Sel), new ArrayRef<SourceLocation>(SelLocs), SelLocsK.$deref(), Method, 
                new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RBracLoc), isImplicit);
     });
    return _Mem;    
  }

  
  /// \brief Create an instance message send.
  ///
  /// \param Context The ASTContext in which this expression will be created.
  ///
  /// \param T The result type of this message.
  ///
  /// \param VK The value kind of this message.  A message returning
  /// a l-value or r-value reference will be an l-value or x-value,
  /// respectively.
  ///
  /// \param LBracLoc The location of the open square bracket '['.
  ///
  /// \param Receiver The expression used to produce the object that
  /// will receive this message.
  ///
  /// \param Sel The selector used to determine which method gets called.
  ///
  /// \param Method The Objective-C method against which this message
  /// send was type-checked. May be NULL.
  ///
  /// \param Args The message send arguments.
  ///
  /// \param RBracLoc The location of the closing square bracket ']'.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 239,
   FQN="clang::ObjCMessageExpr::Create", NM="_ZN5clang15ObjCMessageExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPNS_4ExprENS_8SelectorEN4llvm8ArrayRefIS6_EEPNS_14ObjCMethodDeclENSB_IS8_EES6_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPNS_4ExprENS_8SelectorEN4llvm8ArrayRefIS6_EEPNS_14ObjCMethodDeclENSB_IS8_EES6_b")
  //</editor-fold>
  public static ObjCMessageExpr /*P*/ Create2(final /*const*/ ASTContext /*&*/ Context, QualType T, ExprValueKind VK, 
         SourceLocation LBracLoc, Expr /*P*/ Receiver, Selector Sel, 
         ArrayRef<SourceLocation> SelLocs, 
         ObjCMethodDecl /*P*/ Method, ArrayRef<Expr /*P*/ > Args, 
         SourceLocation RBracLoc, boolean isImplicit) {
    assert ((!SelLocs.empty() || isImplicit)) : "No selector locs for non-implicit message";
    final type$ptr /*P*/ $Mem;
    ObjCMessageExpr /*P*/ _Mem;
    type$ref<SelectorLocationsKind> SelLocsK = create_type$ref(SelectorLocationsKind.valueOf(0));
    if (isImplicit) {
      $Mem = alloc(Context, Args.size(), 0);
    } else {
      $Mem = alloc(Context, new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RBracLoc), new ArrayRef<SourceLocation>(SelLocs), new Selector(Sel), SelLocsK);
    }
    /*NEW_EXPR [Stmt::new]*/_Mem = /*new (Mem)*/ Stmt.$new($Mem, (type$ptr<?> Mem)->{
        return new ObjCMessageExpr(JD$QualType_ExprValueKind_SourceLocation_Expr$P_Selector_ArrayRef$SourceLocation_SelectorLocationsKind_ObjCMethodDecl$P_ArrayRef$Expr$P_SourceLocation_Bool.INSTANCE, new QualType(T), VK, new SourceLocation(LBracLoc), Receiver, new Selector(Sel), new ArrayRef<SourceLocation>(SelLocs), SelLocsK.$deref(), Method, 
                new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RBracLoc), isImplicit);
     });
    return _Mem;    
  }

  
  /// \brief Create an empty Objective-C message expression, to be
  /// filled in by subsequent calls.
  ///
  /// \param Context The context in which the message send will be created.
  ///
  /// \param NumArgs The number of message arguments, not including
  /// the receiver.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 258,
   FQN="clang::ObjCMessageExpr::CreateEmpty", NM="_ZN5clang15ObjCMessageExpr11CreateEmptyERKNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr11CreateEmptyERKNS_10ASTContextEjj")
  //</editor-fold>
  public static ObjCMessageExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ Context, 
             /*uint*/int NumArgs, 
             /*uint*/int NumStoredSelLocs) {
    ObjCMessageExpr /*P*/ _Mem;
    type$ptr /*P*/ $Mem = alloc(Context, NumArgs, NumStoredSelLocs);
    /*NEW_EXPR [Stmt::new]*/_Mem = /*new (Mem)*/ Stmt.$new($Mem, (type$ptr<?> Mem)->{
        return new ObjCMessageExpr(new EmptyShell(), NumArgs);
     });
    return _Mem;
  }

  
  /// \brief Indicates whether the message send was implicitly
  /// generated by the implementation. If false, it was written explicitly
  /// in the source code.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::isImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1132,
   FQN="clang::ObjCMessageExpr::isImplicit", NM="_ZNK5clang15ObjCMessageExpr10isImplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr10isImplicitEv")
  //</editor-fold>
  public boolean isImplicit() /*const*/ {
    return IsImplicit;
  }

  
  /// \brief Determine the kind of receiver that this message is being
  /// sent to.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getReceiverKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1136,
   FQN="clang::ObjCMessageExpr::getReceiverKind", NM="_ZNK5clang15ObjCMessageExpr15getReceiverKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr15getReceiverKindEv")
  //</editor-fold>
  public ReceiverKind getReceiverKind() /*const*/ {
    return ReceiverKind.valueOf($8bits_uint2uint(Kind));
  }

  
  /// \brief Source range of the receiver.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getReceiverRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 290,
   FQN="clang::ObjCMessageExpr::getReceiverRange", NM="_ZNK5clang15ObjCMessageExpr16getReceiverRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr16getReceiverRangeEv")
  //</editor-fold>
  public SourceRange getReceiverRange() /*const*/ {
    switch (getReceiverKind()) {
     case Instance:
      return getInstanceReceiver$Const().getSourceRange();
     case Class:
      return getClassReceiverTypeInfo().getTypeLoc().getSourceRange();
     case SuperInstance:
     case SuperClass:
      return new SourceRange(getSuperLoc());
    }
    throw new llvm_unreachable("Invalid ReceiverKind!");
  }

  
  /// \brief Determine whether this is an instance message to either a
  /// computed object or to super.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::isInstanceMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1143,
   FQN="clang::ObjCMessageExpr::isInstanceMessage", NM="_ZNK5clang15ObjCMessageExpr17isInstanceMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr17isInstanceMessageEv")
  //</editor-fold>
  public boolean isInstanceMessage() /*const*/ {
    return getReceiverKind() == ReceiverKind.Instance || getReceiverKind() == ReceiverKind.SuperInstance;
  }

  
  /// \brief Determine whether this is an class message to either a
  /// specified class or to super.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::isClassMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1149,
   FQN="clang::ObjCMessageExpr::isClassMessage", NM="_ZNK5clang15ObjCMessageExpr14isClassMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr14isClassMessageEv")
  //</editor-fold>
  public boolean isClassMessage() /*const*/ {
    return getReceiverKind() == ReceiverKind.Class || getReceiverKind() == ReceiverKind.SuperClass;
  }

  
  /// \brief Returns the object expression (receiver) for an instance message,
  /// or null for a message that is not an instance message.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getInstanceReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1155,
   FQN="clang::ObjCMessageExpr::getInstanceReceiver", NM="_ZN5clang15ObjCMessageExpr19getInstanceReceiverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr19getInstanceReceiverEv")
  //</editor-fold>
  public Expr /*P*/ getInstanceReceiver() {
    if (getReceiverKind() == ReceiverKind.Instance) {
      return ((/*static_cast*/Expr /*P*/ )(getReceiverPointer()));
    }
    
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getInstanceReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1161,
   FQN="clang::ObjCMessageExpr::getInstanceReceiver", NM="_ZNK5clang15ObjCMessageExpr19getInstanceReceiverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr19getInstanceReceiverEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getInstanceReceiver$Const() /*const*/ {
    return ((/*const_cast*/ObjCMessageExpr /*P*/ )(this)).getInstanceReceiver();
  }

  
  /// \brief Turn this message send into an instance message that
  /// computes the receiver object with the given expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::setInstanceReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1167,
   FQN="clang::ObjCMessageExpr::setInstanceReceiver", NM="_ZN5clang15ObjCMessageExpr19setInstanceReceiverEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr19setInstanceReceiverEPNS_4ExprE")
  //</editor-fold>
  public void setInstanceReceiver(Expr /*P*/ rec) {
    Kind = $uint2uint_8bits(ReceiverKind.Instance.getValue());
    setReceiverPointer(rec);
  }

  
  /// \brief Returns the type of a class message send, or NULL if the
  /// message is not a class message.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getClassReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1174,
   FQN="clang::ObjCMessageExpr::getClassReceiver", NM="_ZNK5clang15ObjCMessageExpr16getClassReceiverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr16getClassReceiverEv")
  //</editor-fold>
  public QualType getClassReceiver() /*const*/ {
    {
      TypeSourceInfo /*P*/ TSInfo = getClassReceiverTypeInfo();
      if ((TSInfo != null)) {
        return TSInfo.getType();
      }
    }
    
    return new QualType();
  }

  
  /// \brief Returns a type-source information of a class message
  /// send, or NULL if the message is not a class message.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getClassReceiverTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1183,
   FQN="clang::ObjCMessageExpr::getClassReceiverTypeInfo", NM="_ZNK5clang15ObjCMessageExpr24getClassReceiverTypeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr24getClassReceiverTypeInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getClassReceiverTypeInfo() /*const*/ {
    if (getReceiverKind() == ReceiverKind.Class) {
      return reinterpret_cast(TypeSourceInfo /*P*/ .class, getReceiverPointer());
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::setClassReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1189,
   FQN="clang::ObjCMessageExpr::setClassReceiver", NM="_ZN5clang15ObjCMessageExpr16setClassReceiverEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr16setClassReceiverEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setClassReceiver(TypeSourceInfo /*P*/ TSInfo) {
    Kind = $uint2uint_8bits(ReceiverKind.Class.getValue());
    setReceiverPointer(TSInfo);
  }

  
  /// \brief Retrieve the location of the 'super' keyword for a class
  /// or instance message to 'super', otherwise an invalid source location.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getSuperLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1196,
   FQN="clang::ObjCMessageExpr::getSuperLoc", NM="_ZNK5clang15ObjCMessageExpr11getSuperLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr11getSuperLocEv")
  //</editor-fold>
  public SourceLocation getSuperLoc() /*const*/ {
    if (getReceiverKind() == ReceiverKind.SuperInstance || getReceiverKind() == ReceiverKind.SuperClass) {
      return new SourceLocation(SuperLoc);
    }
    
    return new SourceLocation();
  }

  
  /// \brief Retrieve the receiver type to which this message is being directed.
  ///
  /// This routine cross-cuts all of the different kinds of message
  /// sends to determine what the underlying (statically known) type
  /// of the receiver will be; use \c getReceiverKind() to determine
  /// whether the message is a class or an instance method, whether it
  /// is a send to super or not, etc.
  ///
  /// \returns The type of the receiver.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getReceiverType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 313,
   FQN="clang::ObjCMessageExpr::getReceiverType", NM="_ZNK5clang15ObjCMessageExpr15getReceiverTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr15getReceiverTypeEv")
  //</editor-fold>
  public QualType getReceiverType() /*const*/ {
    switch (getReceiverKind()) {
     case Instance:
      return getInstanceReceiver$Const().getType();
     case Class:
      return getClassReceiver();
     case SuperInstance:
     case SuperClass:
      return getSuperType();
    }
    throw new llvm_unreachable("unexpected receiver kind");
  }

  
  /// \brief Retrieve the Objective-C interface to which this message
  /// is being directed, if known.
  ///
  /// This routine cross-cuts all of the different kinds of message
  /// sends to determine what the underlying (statically known) type
  /// of the receiver will be; use \c getReceiverKind() to determine
  /// whether the message is a class or an instance method, whether it
  /// is a send to super or not, etc.
  ///
  /// \returns The Objective-C interface if known, otherwise NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getReceiverInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 327,
   FQN="clang::ObjCMessageExpr::getReceiverInterface", NM="_ZNK5clang15ObjCMessageExpr20getReceiverInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr20getReceiverInterfaceEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getReceiverInterface() /*const*/ {
    QualType T = getReceiverType();
    {
      
      /*const*/ ObjCObjectPointerType /*P*/ Ptr = T.$arrow().getAs(ObjCObjectPointerType.class);
      if ((Ptr != null)) {
        return Ptr.getInterfaceDecl();
      }
    }
    {
      
      /*const*/ ObjCObjectType /*P*/ Ty = T.$arrow().getAs(ObjCObjectType.class);
      if ((Ty != null)) {
        return Ty.getInterface();
      }
    }
    
    return null;
  }

  
  /// \brief Retrieve the type referred to by 'super'. 
  ///
  /// The returned type will either be an ObjCInterfaceType (for an
  /// class message to super) or an ObjCObjectPointerType that refers
  /// to a class (for an instance message to super);
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getSuperType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1231,
   FQN="clang::ObjCMessageExpr::getSuperType", NM="_ZNK5clang15ObjCMessageExpr12getSuperTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr12getSuperTypeEv")
  //</editor-fold>
  public QualType getSuperType() /*const*/ {
    if (getReceiverKind() == ReceiverKind.SuperInstance || getReceiverKind() == ReceiverKind.SuperClass) {
      return QualType.getFromOpaquePtr(getReceiverPointer());
    }
    
    return new QualType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::setSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1238,
   FQN="clang::ObjCMessageExpr::setSuper", NM="_ZN5clang15ObjCMessageExpr8setSuperENS_14SourceLocationENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr8setSuperENS_14SourceLocationENS_8QualTypeEb")
  //</editor-fold>
  public void setSuper(SourceLocation Loc, QualType T, boolean IsInstanceSuper) {
    Kind = $uint2uint_8bits(IsInstanceSuper ? ReceiverKind.SuperInstance.getValue() : ReceiverKind.SuperClass.getValue());
    SuperLoc.$assign(Loc);
    setReceiverPointer(T.getAsOpaquePtr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 306,
   FQN="clang::ObjCMessageExpr::getSelector", NM="_ZNK5clang15ObjCMessageExpr11getSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr11getSelectorEv")
  //</editor-fold>
  public Selector getSelector() /*const*/ {
    if (HasMethod) {
      return reinterpret_cast(/*const*/ ObjCMethodDecl /*P*/ .class, SelectorOrMethod).
          getSelector();
    }
    return new Selector(SelectorOrMethod);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::setSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1246,
   FQN="clang::ObjCMessageExpr::setSelector", NM="_ZN5clang15ObjCMessageExpr11setSelectorENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr11setSelectorENS_8SelectorE")
  //</editor-fold>
  public void setSelector(Selector S) {
    HasMethod = false;
    SelectorOrMethod = reinterpret_cast_Object/*uintptr_t*/(S.getAsOpaquePtr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1251,
   FQN="clang::ObjCMessageExpr::getMethodDecl", NM="_ZNK5clang15ObjCMessageExpr13getMethodDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr13getMethodDeclEv")
  //</editor-fold>
  public /*const*/ ObjCMethodDecl /*P*/ getMethodDecl$Const() /*const*/ {
    if (HasMethod) {
      return reinterpret_cast(/*const*/ ObjCMethodDecl /*P*/ .class, SelectorOrMethod);
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1258,
   FQN="clang::ObjCMessageExpr::getMethodDecl", NM="_ZN5clang15ObjCMessageExpr13getMethodDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr13getMethodDeclEv")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getMethodDecl() {
    if (HasMethod) {
      return reinterpret_cast(ObjCMethodDecl /*P*/ .class, SelectorOrMethod);
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::setMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1265,
   FQN="clang::ObjCMessageExpr::setMethodDecl", NM="_ZN5clang15ObjCMessageExpr13setMethodDeclEPNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr13setMethodDeclEPNS_14ObjCMethodDeclE")
  //</editor-fold>
  public void setMethodDecl(ObjCMethodDecl /*P*/ MD) {
    HasMethod = true;
    SelectorOrMethod = reinterpret_cast_Object/*uintptr_t*/(MD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getMethodFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1270,
   FQN="clang::ObjCMessageExpr::getMethodFamily", NM="_ZNK5clang15ObjCMessageExpr15getMethodFamilyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr15getMethodFamilyEv")
  //</editor-fold>
  public ObjCMethodFamily getMethodFamily() /*const*/ {
    if (HasMethod) {
      return getMethodDecl$Const().getMethodFamily();
    }
    return getSelector().getMethodFamily();
  }

  
  /// \brief Return the number of actual arguments in this message,
  /// not counting the receiver.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1277,
   FQN="clang::ObjCMessageExpr::getNumArgs", NM="_ZNK5clang15ObjCMessageExpr10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return NumArgs;
  }

  
  /// \brief Retrieve the arguments to this message, not including the
  /// receiver.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1281,
   FQN="clang::ObjCMessageExpr::getArgs", NM="_ZN5clang15ObjCMessageExpr7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr7getArgsEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> getArgs() {
    return ((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, this.<Object/*void P*/ >getTrailingObjects$VoidPtr().$add(1)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1284,
   FQN="clang::ObjCMessageExpr::getArgs", NM="_ZNK5clang15ObjCMessageExpr7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr7getArgsEv")
  //</editor-fold>
  public type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> getArgs$Const() /*const*/ {
    return ((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, this.<Object/*void P*/ >getTrailingObjects$VoidPtr$Const().$add(1)));
  }

  
  /// getArg - Return the specified argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1290,
   FQN="clang::ObjCMessageExpr::getArg", NM="_ZN5clang15ObjCMessageExpr6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr6getArgEj")
  //</editor-fold>
  public Expr /*P*/ getArg(/*uint*/int Arg) {
    assert ($less_uint(Arg, NumArgs)) : "Arg access out of range!";
    return getArgs().$at(Arg);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1294,
   FQN="clang::ObjCMessageExpr::getArg", NM="_ZNK5clang15ObjCMessageExpr6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr6getArgEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getArg$Const(/*uint*/int Arg) /*const*/ {
    assert ($less_uint(Arg, NumArgs)) : "Arg access out of range!";
    return getArgs$Const().$at(Arg);
  }

  /// setArg - Set the specified argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::setArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1299,
   FQN="clang::ObjCMessageExpr::setArg", NM="_ZN5clang15ObjCMessageExpr6setArgEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr6setArgEjPNS_4ExprE")
  //</editor-fold>
  public void setArg(/*uint*/int Arg, Expr /*P*/ ArgExpr) {
    assert ($less_uint(Arg, NumArgs)) : "Arg access out of range!";
    getArgs().$set(Arg, ArgExpr);
  }

  
  /// isDelegateInitCall - Answers whether this message send has been
  /// tagged as a "delegate init call", i.e. a call to a method in the
  /// -init family on self from within an -init method implementation.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::isDelegateInitCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1307,
   FQN="clang::ObjCMessageExpr::isDelegateInitCall", NM="_ZNK5clang15ObjCMessageExpr18isDelegateInitCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr18isDelegateInitCallEv")
  //</editor-fold>
  public boolean isDelegateInitCall() /*const*/ {
    return IsDelegateInitCall;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::setDelegateInitCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1308,
   FQN="clang::ObjCMessageExpr::setDelegateInitCall", NM="_ZN5clang15ObjCMessageExpr19setDelegateInitCallEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr19setDelegateInitCallEb")
  //</editor-fold>
  public void setDelegateInitCall(boolean isDelegate) {
    IsDelegateInitCall = isDelegate;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getLeftLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1310,
   FQN="clang::ObjCMessageExpr::getLeftLoc", NM="_ZNK5clang15ObjCMessageExpr10getLeftLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr10getLeftLocEv")
  //</editor-fold>
  public SourceLocation getLeftLoc() /*const*/ {
    return new SourceLocation(LBracLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getRightLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1311,
   FQN="clang::ObjCMessageExpr::getRightLoc", NM="_ZNK5clang15ObjCMessageExpr11getRightLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr11getRightLocEv")
  //</editor-fold>
  public SourceLocation getRightLoc() /*const*/ {
    return new SourceLocation(RBracLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getSelectorStartLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1313,
   FQN="clang::ObjCMessageExpr::getSelectorStartLoc", NM="_ZNK5clang15ObjCMessageExpr19getSelectorStartLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr19getSelectorStartLocEv")
  //</editor-fold>
  public SourceLocation getSelectorStartLoc() /*const*/ {
    if (isImplicit()) {
      return getLocStart();
    }
    return getSelectorLoc(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getSelectorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1318,
   FQN="clang::ObjCMessageExpr::getSelectorLoc", NM="_ZNK5clang15ObjCMessageExpr14getSelectorLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr14getSelectorLocEj")
  //</editor-fold>
  public SourceLocation getSelectorLoc(/*uint*/int Index) /*const*/ {
    assert ($less_uint(Index, getNumSelectorLocs())) : "Index out of range!";
    if (hasStandardSelLocs()) {
      return getStandardSelectorLocExprs(Index, getSelector(), 
          getSelLocsKind() == SelectorLocationsKind.SelLoc_StandardWithSpace, 
          llvm.makeArrayRef(((/*const_cast*/type$ptr<Expr /*P*/ /*P*/>)(getArgs$Const())), 
              getNumArgs()), 
          new SourceLocation(RBracLoc));
    }
    return new SourceLocation(getStoredSelLocs$Const().$at(Index));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getSelectorLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 284,
   FQN="clang::ObjCMessageExpr::getSelectorLocs", NM="_ZNK5clang15ObjCMessageExpr15getSelectorLocsERN4llvm15SmallVectorImplINS_14SourceLocationEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr15getSelectorLocsERN4llvm15SmallVectorImplINS_14SourceLocationEEE")
  //</editor-fold>
  public void getSelectorLocs(final SmallVectorImpl<SourceLocation> /*&*/ SelLocs) /*const*/ {
    for (/*uint*/int i = 0, e = getNumSelectorLocs(); i != e; ++i)  {
      SelLocs.push_back(getSelectorLoc(i));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getNumSelectorLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1331,
   FQN="clang::ObjCMessageExpr::getNumSelectorLocs", NM="_ZNK5clang15ObjCMessageExpr18getNumSelectorLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr18getNumSelectorLocsEv")
  //</editor-fold>
  public /*uint*/int getNumSelectorLocs() /*const*/ {
    if (isImplicit()) {
      return 0;
    }
    Selector Sel = getSelector();
    if (Sel.isUnarySelector()) {
      return 1;
    }
    return Sel.getNumArgs();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::setSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1340,
   FQN="clang::ObjCMessageExpr::setSourceRange", NM="_ZN5clang15ObjCMessageExpr14setSourceRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr14setSourceRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setSourceRange(SourceRange R) {
    LBracLoc.$assignMove(R.getBegin());
    RBracLoc.$assignMove(R.getEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1344,
   FQN="clang::ObjCMessageExpr::getLocStart", NM="_ZNK5clang15ObjCMessageExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(LBracLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1345,
   FQN="clang::ObjCMessageExpr::getLocEnd", NM="_ZNK5clang15ObjCMessageExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RBracLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1347,
   FQN="clang::ObjCMessageExpr::classof", NM="_ZN5clang15ObjCMessageExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCMessageExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 339,
   FQN="clang::ObjCMessageExpr::children", NM="_ZN5clang15ObjCMessageExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    type$ptr<Stmt /*P*/ /*P*/> begin = create_type$ptr();
    if (getReceiverKind() == ReceiverKind.Instance) {
      begin = $tryClone(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, this.<Object/*void P*/ >getTrailingObjects$VoidPtr())));
    } else {
      begin = $tryClone(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, getArgs())));
    }
    return new iterator_range<Stmt/*P*/>(new StmtIterator(begin), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, getArgs().$add(getNumArgs())))));
  }

  
  /*typedef ExprIterator arg_iterator*/
//  public final class arg_iterator extends ExprIterator{ };
  /*typedef ConstExprIterator const_arg_iterator*/
//  public final class const_arg_iterator extends ConstExprIterator{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1357,
   FQN="clang::ObjCMessageExpr::arguments", NM="_ZN5clang15ObjCMessageExpr9argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr9argumentsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > arguments() {
    return llvm.make_range(arg_begin(), arg_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1361,
   FQN="clang::ObjCMessageExpr::arguments", NM="_ZNK5clang15ObjCMessageExpr9argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr9argumentsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> arguments$Const() /*const*/ {
    return llvm.make_range(arg_begin$Const(), arg_end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1365,
   FQN="clang::ObjCMessageExpr::arg_begin", NM="_ZN5clang15ObjCMessageExpr9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr9arg_beginEv")
  //</editor-fold>
  public ExprIterator arg_begin() {
    return new ExprIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, getArgs())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1366,
   FQN="clang::ObjCMessageExpr::arg_end", NM="_ZN5clang15ObjCMessageExpr7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang15ObjCMessageExpr7arg_endEv")
  //</editor-fold>
  public ExprIterator arg_end() {
    return new ExprIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, getArgs().$add(NumArgs))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1369,
   FQN="clang::ObjCMessageExpr::arg_begin", NM="_ZNK5clang15ObjCMessageExpr9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr9arg_beginEv")
  //</editor-fold>
  public ConstExprIterator arg_begin$Const() /*const*/ {
    return new ConstExprIterator(((type$ptr</*const*/ Stmt /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, getArgs$Const())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMessageExpr::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1372,
   FQN="clang::ObjCMessageExpr::arg_end", NM="_ZNK5clang15ObjCMessageExpr7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang15ObjCMessageExpr7arg_endEv")
  //</editor-fold>
  public ConstExprIterator arg_end$Const() /*const*/ {
    return new ConstExprIterator(((type$ptr</*const*/ Stmt /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, getArgs$Const().$add(NumArgs))));
  }

  
  /*friend  TrailingObjects<ObjCMessageExpr, void *, SourceLocation>*/
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public /*size_t*/ int getNumTailingObject_OverloadToken$TrailingTy1() {
    return numTrailingObjects((OverloadToken<Object/*void P*/>) null);
  }

  @Override
  public type$ptr<Object> getTrailingObjects$VoidPtr() {
    return (type$ptr<Object>) super.$this$plus1();
  }

  @Override
  public </*typename*/ T> type$ptr</*const*/ T /*P*/> getTrailingObjects(Class<T> clazz) {
    assert clazz == SourceLocation.class;
    return (type$ptr</*const*/ T /*P*/>) getTrailingObjects$VoidPtr().$add(getNumTailingObject_OverloadToken$TrailingTy1());
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "SelectorOrMethod=" + SelectorOrMethod // NOI18N
              + ", NumArgs=" + $ushort2uint(NumArgs) // NOI18N
              + ", Kind=" + $uchar2uint(Kind) // NOI18N
              + ", HasMethod=" + HasMethod // NOI18N
              + ", IsDelegateInitCall=" + IsDelegateInitCall // NOI18N
              + ", IsImplicit=" + IsImplicit // NOI18N
              + ", SelLocsKind=" + $uchar2uint(SelLocsKind) // NOI18N
              + ", SuperLoc=" + SuperLoc // NOI18N
              + ", LBracLoc=" + LBracLoc // NOI18N
              + ", RBracLoc=" + RBracLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
