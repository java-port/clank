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
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clank.java.std;
import static org.clank.support.Native.$Clone;
import org.llvm.support.TrailingObjects.*;


/// ObjCDictionaryLiteral - AST node to represent objective-c dictionary
/// literals; as in:  @{@"name" : NSUserName(), @"date" : [NSDate date] };
//<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 257,
 FQN="clang::ObjCDictionaryLiteral", NM="_ZN5clang21ObjCDictionaryLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang21ObjCDictionaryLiteralE")
//</editor-fold>
public final class ObjCDictionaryLiteral extends /*public*/ Expr implements /*private*/ TrailingObjects2<ObjCDictionaryLiteral, ObjCDictionaryLiteral_KeyValuePair, ObjCDictionaryLiteral_ExpansionData> {
  /// \brief The number of elements in this dictionary literal.
  private /*uint*/int NumElements /*: 31*/;
  
  /// \brief Determine whether this dictionary literal has any pack expansions.
  ///
  /// If the dictionary literal has pack expansions, then there will
  /// be an array of pack expansion data following the array of
  /// key/value pairs, which provide the locations of the ellipses (if
  /// any) and number of elements in the expansion (if known). If
  /// there are no pack expansions, we optimize away this storage.
  /*friend*/public /*JBIT unsigned int*/ boolean HasPackExpansions /*: 1*/;
  
  /*friend*/public SourceRange Range;
  /*friend*/public ObjCMethodDecl /*P*/ DictWithObjectsMethod;
  
  /*typedef ObjCDictionaryLiteral_KeyValuePair KeyValuePair*/
//  public final class KeyValuePair extends ObjCDictionaryLiteral_KeyValuePair{ };
  /*typedef ObjCDictionaryLiteral_ExpansionData ExpansionData*/
//  public final class ExpansionData extends ObjCDictionaryLiteral_ExpansionData{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::numTrailingObjects">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 280,
   FQN="clang::ObjCDictionaryLiteral::numTrailingObjects", NM="_ZNK5clang21ObjCDictionaryLiteral18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_34ObjCDictionaryLiteral_KeyValuePairEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang21ObjCDictionaryLiteral18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_34ObjCDictionaryLiteral_KeyValuePairEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects(TrailingObjects2.OverloadToken<ObjCDictionaryLiteral_KeyValuePair> $Prm0) /*const*/ {
    return NumElements;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::ObjCDictionaryLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 53,
   FQN="clang::ObjCDictionaryLiteral::ObjCDictionaryLiteral", NM="_ZN5clang21ObjCDictionaryLiteralC1EN4llvm8ArrayRefINS_21ObjCDictionaryElementEEEbNS_8QualTypeEPNS_14ObjCMethodDeclENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang21ObjCDictionaryLiteralC1EN4llvm8ArrayRefINS_21ObjCDictionaryElementEEEbNS_8QualTypeEPNS_14ObjCMethodDeclENS_11SourceRangeE")
  //</editor-fold>
  private ObjCDictionaryLiteral(ArrayRef<ObjCDictionaryElement> VK, 
      boolean HasPackExpansions, QualType T, 
      ObjCMethodDecl /*P*/ method, 
      SourceRange SR) {
    // : Expr(ObjCDictionaryLiteralClass, T, VK_RValue, OK_Ordinary, false, false, false, false), TrailingObjects<ObjCDictionaryLiteral, ObjCDictionaryLiteral_KeyValuePair, ObjCDictionaryLiteral_ExpansionData>(), NumElements(VK.size()), HasPackExpansions(HasPackExpansions), Range(SR), DictWithObjectsMethod(method) 
    //START JInit
    super(StmtClass.ObjCDictionaryLiteralClass, new QualType(T), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, 
        false, false);
    $TrailingObjects();
    this.NumElements = VK.size();
    this.HasPackExpansions = HasPackExpansions;
    this.Range = new SourceRange(SR);
    this.DictWithObjectsMethod = method;
    //END JInit
    type$ptr<ObjCDictionaryLiteral_KeyValuePair /*P*/> KeyValues = getTrailingObjects(ObjCDictionaryLiteral_KeyValuePair.class);
    type$ptr<ObjCDictionaryLiteral_ExpansionData /*P*/> Expansions = HasPackExpansions ? getTrailingObjects(ObjCDictionaryLiteral_ExpansionData.class) : null;
    for (/*uint*/int I = 0; $less_uint(I, NumElements); I++) {
      if (VK.$at(I).Key.isTypeDependent() || VK.$at(I).Key.isValueDependent()
         || VK.$at(I).Value.isTypeDependent() || VK.$at(I).Value.isValueDependent()) {
        Unnamed_field.ExprBits.ValueDependent = true;
      }
      if (VK.$at(I).Key.isInstantiationDependent()
         || VK.$at(I).Value.isInstantiationDependent()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (VK.$at(I).EllipsisLoc.isInvalid()
         && (VK.$at(I).Key.containsUnexpandedParameterPack()
         || VK.$at(I).Value.containsUnexpandedParameterPack())) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
      
      KeyValues.$at(I).Key = VK.$at(I).Key;
      KeyValues.$at(I).Value = VK.$at(I).Value;
      if ((Expansions != null)) {
        Expansions.$at(I).EllipsisLoc.$assign(VK.$at(I).EllipsisLoc);
        if (VK.$at(I).NumExpansions.$bool()) {
          Expansions.$at(I).NumExpansionsPlusOne = VK.$at(I).NumExpansions.$star() + 1;
        } else {
          Expansions.$at(I).NumExpansionsPlusOne = 0;
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::ObjCDictionaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 289,
   FQN="clang::ObjCDictionaryLiteral::ObjCDictionaryLiteral", NM="_ZN5clang21ObjCDictionaryLiteralC1ENS_4Stmt10EmptyShellEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang21ObjCDictionaryLiteralC1ENS_4Stmt10EmptyShellEjb")
  //</editor-fold>
  private /*explicit*/ ObjCDictionaryLiteral(Stmt.EmptyShell Empty, /*uint*/int NumElements, 
      boolean HasPackExpansions) {
    // : Expr(ObjCDictionaryLiteralClass, Empty), TrailingObjects<ObjCDictionaryLiteral, ObjCDictionaryLiteral_KeyValuePair, ObjCDictionaryLiteral_ExpansionData>(), NumElements(NumElements), HasPackExpansions(HasPackExpansions), Range() 
    //START JInit
    super(StmtClass.ObjCDictionaryLiteralClass, new Stmt.EmptyShell(Empty));
    $TrailingObjects();
    this.NumElements = NumElements;
    this.HasPackExpansions = HasPackExpansions;
    this.Range = new SourceRange();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ALLOC*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 88,
   FQN="clang::ObjCDictionaryLiteral::Create", NM="_ZN5clang21ObjCDictionaryLiteral6CreateERKNS_10ASTContextEN4llvm8ArrayRefINS_21ObjCDictionaryElementEEEbNS_8QualTypeEPNS_14ObjCMethodDeclENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang21ObjCDictionaryLiteral6CreateERKNS_10ASTContextEN4llvm8ArrayRefINS_21ObjCDictionaryElementEEEbNS_8QualTypeEPNS_14ObjCMethodDeclENS_11SourceRangeE")
  //</editor-fold>
  public static ObjCDictionaryLiteral /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        ArrayRef<ObjCDictionaryElement> VK, 
        boolean HasPackExpansions, QualType T, 
        ObjCMethodDecl /*P*/ method, SourceRange SR) {
    Object/*void P*/ Mem;
    if (false) {
      Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(ObjCDictionaryLiteral_KeyValuePair.class, ObjCDictionaryLiteral_ExpansionData.class, VK.size(), HasPackExpansions ? VK.size() : 0));
    } else {
      Mem = C.Allocate$JavaRef(
              TrailingObjects.totalSizeToAlloc$Same(
                      ObjCDictionaryLiteral_KeyValuePair.class, 
                      ObjCDictionaryLiteral_ExpansionData.class, 
                      VK.size(), 
                      HasPackExpansions ? VK.size() : 0),
              std.make_pair_int_Ptr(1, ()->null), // for this
              std.make_pair_int_Ptr(VK.size(), ()->new ObjCDictionaryLiteral_KeyValuePair()), 
              std.make_pair_int_Ptr((HasPackExpansions ? VK.size() : 0), ()->new ObjCDictionaryLiteral_ExpansionData())
      );
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new ObjCDictionaryLiteral(new ArrayRef<ObjCDictionaryElement>(VK), HasPackExpansions, new QualType(T), method, new SourceRange(SR));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ALLOC*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 98,
   FQN="clang::ObjCDictionaryLiteral::CreateEmpty", NM="_ZN5clang21ObjCDictionaryLiteral11CreateEmptyERKNS_10ASTContextEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang21ObjCDictionaryLiteral11CreateEmptyERKNS_10ASTContextEjb")
  //</editor-fold>
  public static ObjCDictionaryLiteral /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, /*uint*/int NumElements, 
             boolean HasPackExpansions) {
    Object/*void P*/ Mem;
    if (false) {
      Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(ObjCDictionaryLiteral_KeyValuePair.class, ObjCDictionaryLiteral_ExpansionData.class, NumElements, HasPackExpansions ? NumElements : 0));
    } else {
      Mem = C.Allocate$JavaRef(
              TrailingObjects.totalSizeToAlloc$Same(
                      ObjCDictionaryLiteral_KeyValuePair.class, 
                      ObjCDictionaryLiteral_ExpansionData.class, 
                      NumElements, 
                      HasPackExpansions ? NumElements : 0),
              std.make_pair_int_Ptr(1, ()->null), // for this
              std.make_pair_int_Ptr(NumElements, ()->new ObjCDictionaryLiteral_KeyValuePair()), 
              std.make_pair_int_Ptr((HasPackExpansions ? NumElements : 0), ()->new ObjCDictionaryLiteral_ExpansionData())
      );   
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new ObjCDictionaryLiteral(new Stmt.EmptyShell(), NumElements, HasPackExpansions);
     });
  }

  
  /// getNumElements - Return number of elements of objective-c dictionary 
  /// literal.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::getNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 307,
   FQN="clang::ObjCDictionaryLiteral::getNumElements", NM="_ZNK5clang21ObjCDictionaryLiteral14getNumElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang21ObjCDictionaryLiteral14getNumElementsEv")
  //</editor-fold>
  public /*uint*/int getNumElements() /*const*/ {
    return NumElements;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::getKeyValueElement">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 309,
   FQN="clang::ObjCDictionaryLiteral::getKeyValueElement", NM="_ZNK5clang21ObjCDictionaryLiteral18getKeyValueElementEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang21ObjCDictionaryLiteral18getKeyValueElementEj")
  //</editor-fold>
  public ObjCDictionaryElement getKeyValueElement(/*uint*/int Index) /*const*/ {
    assert (($less_uint(Index, NumElements))) : "Arg access out of range!";
    final /*const*/ ObjCDictionaryLiteral_KeyValuePair /*&*/ KV = getTrailingObjects$Const(ObjCDictionaryLiteral_KeyValuePair.class).$at(Index);
    ObjCDictionaryElement Result = new ObjCDictionaryElement(KV.Key, KV.Value, new SourceLocation(), OptionalUInt.None());
    if (HasPackExpansions) {
      final /*const*/ ObjCDictionaryLiteral_ExpansionData /*&*/ Expansion = getTrailingObjects$Const(ObjCDictionaryLiteral_ExpansionData.class).$at(Index);
      Result.EllipsisLoc.$assign(Expansion.EllipsisLoc);
      if ($greater_uint(Expansion.NumExpansionsPlusOne, 0)) {
        Result.NumExpansions.$assign_T$C$R(Expansion.NumExpansionsPlusOne - 1);
      }
    }
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::getDictWithObjectsMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 323,
   FQN="clang::ObjCDictionaryLiteral::getDictWithObjectsMethod", NM="_ZNK5clang21ObjCDictionaryLiteral24getDictWithObjectsMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang21ObjCDictionaryLiteral24getDictWithObjectsMethodEv")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getDictWithObjectsMethod() /*const*/ {
    return DictWithObjectsMethod;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 326,
   FQN="clang::ObjCDictionaryLiteral::getLocStart", NM="_ZNK5clang21ObjCDictionaryLiteral11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang21ObjCDictionaryLiteral11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 327,
   FQN="clang::ObjCDictionaryLiteral::getLocEnd", NM="_ZNK5clang21ObjCDictionaryLiteral9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang21ObjCDictionaryLiteral9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 328,
   FQN="clang::ObjCDictionaryLiteral::getSourceRange", NM="_ZNK5clang21ObjCDictionaryLiteral14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang21ObjCDictionaryLiteral14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 330,
   FQN="clang::ObjCDictionaryLiteral::classof", NM="_ZN5clang21ObjCDictionaryLiteral7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang21ObjCDictionaryLiteral7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCDictionaryLiteralClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryLiteral::children">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 335,
   FQN="clang::ObjCDictionaryLiteral::children", NM="_ZN5clang21ObjCDictionaryLiteral8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang21ObjCDictionaryLiteral8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    // Note: we're taking advantage of the layout of the KeyValuePair struct
    // here. If that struct changes, this code will need to change as well.
//    return child_range(
//        reinterpret_cast<Stmt **>(getTrailingObjects<KeyValuePair>()),
//        reinterpret_cast<Stmt **>(getTrailingObjects<KeyValuePair>()) +
//            NumElements * 2);    
    // JAVA: we can not emulate this in Java, so create special iterator for that
    // and advance by NumElements, not NumElements*2, because wrapper StmtPtrStmtPtrIterator
    // handle Key/Value separation
    static_assert(ObjCDictionaryLiteral_KeyValuePair.$sizeof_ObjCDictionaryLiteral_KeyValuePair() == $sizeof_ptr(/*Stmt  */) * 2, $("KeyValuePair is expected size"));
    type$ptr<ObjCDictionaryLiteral_KeyValuePair> B = getTrailingObjects(ObjCDictionaryLiteral_KeyValuePair.class);
    type$ptr<ObjCDictionaryLiteral_KeyValuePair> E = B.$add(NumElements);
    return new iterator_range<Stmt/*P*/>(new StmtIterator(new StmtPtrStmtPtrIterator(B)), 
        new StmtIterator(new StmtPtrStmtPtrIterator(E)));
  }

  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  /*friend  TrailingObjects<ObjCDictionaryLiteral, ObjCDictionaryLiteral_KeyValuePair, ObjCDictionaryLiteral_ExpansionData>*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  // Special class to unfold ObjCDictionaryLiteral_KeyValuePair which has two 'Stmt /*P*/' fields
  // into iterator with doubled number of 'Stmt /*P*/' elements
  private static final class StmtPtrStmtPtrIterator implements type$iterator<StmtPtrStmtPtrIterator, Stmt /*P*/ > {
    private final type$ptr<ObjCDictionaryLiteral_KeyValuePair /*P*/> delegate;
    private boolean onValue;

    private StmtPtrStmtPtrIterator(StmtPtrStmtPtrIterator $Prm0) {
      this.delegate = $Clone($Prm0.delegate);
      this.onValue = $Prm0.onValue;
    }

    private StmtPtrStmtPtrIterator(type$ptr<ObjCDictionaryLiteral_KeyValuePair /*P*/> delegate) {
      this.delegate = delegate;
      this.onValue = false;
    }

    @Override
    public Stmt/*P*/ $star() {
      final ObjCDictionaryLiteral_KeyValuePair $star = delegate.$star();
      return onValue ? $star.Value : $star.Key;
    }

    @Override
    public type$ref<Stmt/*P*/> star$ref() {
      return new type$ptr$inout<Stmt>(this) {
        final ObjCDictionaryLiteral_KeyValuePair $star = delegate.$star();
        final boolean $onValue = onValue;
        @Override
        protected Stmt $star$impl() {
          return $onValue ? $star.Value : $star.Key;
        }
      };
    }
    
    @Override public StmtPtrStmtPtrIterator $preInc() {
      if (onValue) {
        delegate.$preInc();
      }
      onValue = !onValue;
      return this;
    }

    @Override public boolean $eq(Object RHS) {
      StmtPtrStmtPtrIterator other = (StmtPtrStmtPtrIterator) RHS;
      return this.onValue == other.onValue && delegate.$eq(other.delegate);
    }

    @Override public StmtPtrStmtPtrIterator clone() {
      return new StmtPtrStmtPtrIterator(this);
    }

    @Override
    public String toString() {
      return "on " + (onValue ? "Value" : "Key") + " element of: " + this.delegate;
    }
  }

  @Override
  public /*size_t*/ int getNumTailingObject_OverloadToken$TrailingTy1() {
    return numTrailingObjects((OverloadToken<ObjCDictionaryLiteral_KeyValuePair>) null);
  }

  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == ObjCDictionaryLiteral_KeyValuePair.class || 
            clazz == ObjCDictionaryLiteral_ExpansionData.class : "Unexpected class " + clazz;
    if (clazz == ObjCDictionaryLiteral_KeyValuePair.class) {
      return 0;
    } else {
      assert clazz == ObjCDictionaryLiteral_ExpansionData.class : "Unexpected class " + clazz;
      return getNumTailingObject_OverloadToken$TrailingTy1();
    }
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NumElements=" + NumElements // NOI18N
              + ", HasPackExpansions=" + HasPackExpansions // NOI18N
              + ", Range=" + Range // NOI18N
              + ", DictWithObjectsMethod=" + DictWithObjectsMethod // NOI18N
              + super.toString(); // NOI18N
  }
}
