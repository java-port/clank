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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// ObjCArrayLiteral - used for objective-c array containers; as in:
/// @[@"Hello", NSApp, [NSNumber numberWithInt:42]];
//<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 144,
 FQN="clang::ObjCArrayLiteral", NM="_ZN5clang16ObjCArrayLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCArrayLiteralE")
//</editor-fold>
public final class ObjCArrayLiteral extends /*public*/ Expr implements /*private*/ TrailingObjects<ObjCArrayLiteral, Expr /*P*/ >, ITrailingObjectsJavaBase<ObjCArrayLiteral> {
  private /*uint*/int NumElements;
  /*friend*/public SourceRange Range;
  /*friend*/public ObjCMethodDecl /*P*/ ArrayWithObjectsMethod;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::ObjCArrayLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 20,
   FQN="clang::ObjCArrayLiteral::ObjCArrayLiteral", NM="_ZN5clang16ObjCArrayLiteralC1EN4llvm8ArrayRefIPNS_4ExprEEENS_8QualTypeEPNS_14ObjCMethodDeclENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCArrayLiteralC1EN4llvm8ArrayRefIPNS_4ExprEEENS_8QualTypeEPNS_14ObjCMethodDeclENS_11SourceRangeE")
  //</editor-fold>
  private ObjCArrayLiteral(ArrayRef<Expr /*P*/ > Elements, QualType T, 
      ObjCMethodDecl /*P*/ Method, SourceRange SR) {
    // : Expr(ObjCArrayLiteralClass, T, VK_RValue, OK_Ordinary, false, false, false, false), TrailingObjects<ObjCArrayLiteral, Expr * >(), NumElements(Elements.size()), Range(SR), ArrayWithObjectsMethod(Method) 
    //START JInit
    super(StmtClass.ObjCArrayLiteralClass, new QualType(T), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, 
        false, false);
    $TrailingObjects();
    this.NumElements = Elements.size();
    this.Range = new SourceRange(SR);
    this.ArrayWithObjectsMethod = Method;
    //END JInit
    type$ptr<Expr /*P*/ /*P*/> SaveElements = $tryClone(getElements());
    for (/*uint*/int I = 0, N = Elements.size(); I != N; ++I) {
      if (Elements.$at(I).isTypeDependent() || Elements.$at(I).isValueDependent()) {
        Unnamed_field.ExprBits.ValueDependent = true;
      }
      if (Elements.$at(I).isInstantiationDependent()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (Elements.$at(I).containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
      
      SaveElements.$set(I, Elements.$at(I));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::ObjCArrayLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 155,
   FQN="clang::ObjCArrayLiteral::ObjCArrayLiteral", NM="_ZN5clang16ObjCArrayLiteralC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCArrayLiteralC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private /*explicit*/ ObjCArrayLiteral(EmptyShell Empty, /*uint*/int NumElements) {
    // : Expr(ObjCArrayLiteralClass, Empty), TrailingObjects<ObjCArrayLiteral, Expr * >(), NumElements(NumElements), Range() 
    //START JInit
    super(StmtClass.ObjCArrayLiteralClass, new EmptyShell(Empty));
    $TrailingObjects();
    this.NumElements = NumElements;
    this.Range = new SourceRange();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 38,
   FQN="clang::ObjCArrayLiteral::Create", NM="_ZN5clang16ObjCArrayLiteral6CreateERKNS_10ASTContextEN4llvm8ArrayRefIPNS_4ExprEEENS_8QualTypeEPNS_14ObjCMethodDeclENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCArrayLiteral6CreateERKNS_10ASTContextEN4llvm8ArrayRefIPNS_4ExprEEENS_8QualTypeEPNS_14ObjCMethodDeclENS_11SourceRangeE")
  //</editor-fold>
  public static ObjCArrayLiteral /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        ArrayRef<Expr /*P*/ > Elements, 
        QualType T, ObjCMethodDecl /*P*/ Method, 
        SourceRange SR) {
    // JAVA: Alloc
    Object/*void P*/ Mem;
    if (false) {
      Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, Elements.size()));
    } else {
      Mem = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(Expr.class, Elements.size()));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new ObjCArrayLiteral(new ArrayRef<Expr /*P*/ >(Elements), new QualType(T), Method, new SourceRange(SR));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ALLOC*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 46,
   FQN="clang::ObjCArrayLiteral::CreateEmpty", NM="_ZN5clang16ObjCArrayLiteral11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCArrayLiteral11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static ObjCArrayLiteral /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int NumElements) {
    
    // JAVA: Alloc
    Object/*void P*/ Mem;
    if (false) {
      Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, NumElements));
    } else {
      Mem = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(Expr.class, NumElements));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new ObjCArrayLiteral(new EmptyShell(), NumElements);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 167,
   FQN="clang::ObjCArrayLiteral::getLocStart", NM="_ZNK5clang16ObjCArrayLiteral11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCArrayLiteral11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 168,
   FQN="clang::ObjCArrayLiteral::getLocEnd", NM="_ZNK5clang16ObjCArrayLiteral9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCArrayLiteral9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 169,
   FQN="clang::ObjCArrayLiteral::getSourceRange", NM="_ZNK5clang16ObjCArrayLiteral14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCArrayLiteral14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 171,
   FQN="clang::ObjCArrayLiteral::classof", NM="_ZN5clang16ObjCArrayLiteral7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCArrayLiteral7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCArrayLiteralClass;
  }

  
  /// \brief Retrieve elements of array of literals.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::getElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 176,
   FQN="clang::ObjCArrayLiteral::getElements", NM="_ZN5clang16ObjCArrayLiteral11getElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCArrayLiteral11getElementsEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> getElements() {
    return getTrailingObjects(Expr /*P*/.class);
  }

  
  /// \brief Retrieve elements of array of literals.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::getElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 179,
   FQN="clang::ObjCArrayLiteral::getElements", NM="_ZNK5clang16ObjCArrayLiteral11getElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCArrayLiteral11getElementsEv")
  //</editor-fold>
  public type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> getElements$Const() /*const*/ {
    return getTrailingObjects$Const(Expr /*P*/.class);
  }

  
  /// getNumElements - Return number of elements of objective-c array literal.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::getNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 184,
   FQN="clang::ObjCArrayLiteral::getNumElements", NM="_ZNK5clang16ObjCArrayLiteral14getNumElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCArrayLiteral14getNumElementsEv")
  //</editor-fold>
  public /*uint*/int getNumElements() /*const*/ {
    return NumElements;
  }

  
  /// getExpr - Return the Expr at the specified index.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::getElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 187,
   FQN="clang::ObjCArrayLiteral::getElement", NM="_ZN5clang16ObjCArrayLiteral10getElementEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCArrayLiteral10getElementEj")
  //</editor-fold>
  public Expr /*P*/ getElement(/*uint*/int Index) {
    assert (($less_uint(Index, NumElements))) : "Arg access out of range!";
    return cast_Expr(getElements().$at(Index));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::getElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 191,
   FQN="clang::ObjCArrayLiteral::getElement", NM="_ZNK5clang16ObjCArrayLiteral10getElementEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCArrayLiteral10getElementEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getElement$Const(/*uint*/int Index) /*const*/ {
    assert (($less_uint(Index, NumElements))) : "Arg access out of range!";
    return cast_Expr(getElements$Const().$at(Index));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::getArrayWithObjectsMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 196,
   FQN="clang::ObjCArrayLiteral::getArrayWithObjectsMethod", NM="_ZNK5clang16ObjCArrayLiteral25getArrayWithObjectsMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCArrayLiteral25getArrayWithObjectsMethodEv")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getArrayWithObjectsMethod() /*const*/ {
    return ArrayWithObjectsMethod;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCArrayLiteral::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 201,
   FQN="clang::ObjCArrayLiteral::children", NM="_ZN5clang16ObjCArrayLiteral8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCArrayLiteral8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, getElements()))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, getElements())).$add(NumElements)));
  }

  
  /*friend  TrailingObjects<ObjCArrayLiteral, Expr *>*/
  /*friend  class ASTStmtReader*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return $this$plus1();
  }
  
  @Override public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == Expr /*P*/.class;
    return 0;
  }

  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override
  public String toString() {
    return "" + "NumElements=" + NumElements // NOI18N
            + ", Range=" + Range // NOI18N
            + ", ArrayWithObjectsMethod=" + ArrayWithObjectsMethod // NOI18N
            + super.toString(); // NOI18N
  }
}
