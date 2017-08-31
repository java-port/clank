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
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.adt.java.TrailingObjectsUtils;


/// Stores a list of Objective-C type parameters for a parameterized class
/// or a category/extension thereof.
///
/// \code
/// @interface NSArray<T> // stores the <T>
/// @end
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 610,
 FQN="clang::ObjCTypeParamList", NM="_ZN5clang17ObjCTypeParamListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamListE")
//</editor-fold>
public final class ObjCTypeParamList implements /*private*/ TrailingObjects<ObjCTypeParamList, ObjCTypeParamDecl /*P*/ >, Iterable<ObjCTypeParamDecl/*P*/> {
  /// Stores the components of a SourceRange as a POD.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::PODSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 613,
   FQN="clang::ObjCTypeParamList::PODSourceRange", NM="_ZN5clang17ObjCTypeParamList14PODSourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamList14PODSourceRangeE")
  //</editor-fold>
  private static class/*struct*/ PODSourceRange {
    public /*uint*/int Begin;
    public /*uint*/int End;
    
    @Override public String toString() {
      return "" + "Begin=" + Begin // NOI18N
                + ", End=" + End; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 618,
   FQN="clang::ObjCTypeParamList::(anonymous)", NM="_ZN5clang17ObjCTypeParamListE_Unnamed_union2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamListE_Unnamed_union2")
  //</editor-fold>
  private static class/*union*/ Unnamed_union2 {
    /// Location of the left and right angle brackets.
    public final PODSourceRange Brackets = new PODSourceRange();
    
    // Used only for alignment.
    public ObjCTypeParamDecl /*P*/ AlignmentHack;
    
    @Override public String toString() {
      return "" + "Brackets=" + Brackets // NOI18N
                + ", AlignmentHack=" + AlignmentHack; // NOI18N
    }
  };
  private final Unnamed_union2 Unnamed_field = new Unnamed_union2();
  
  /// The number of parameters in the list, which are tail-allocated.
  private /*uint*/int NumParams;
  
  
  //===----------------------------------------------------------------------===//
  // ObjCTypeParamList
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::ObjCTypeParamList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1351,
   FQN="clang::ObjCTypeParamList::ObjCTypeParamList", NM="_ZN5clang17ObjCTypeParamListC1ENS_14SourceLocationEN4llvm8ArrayRefIPNS_17ObjCTypeParamDeclEEES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamListC1ENS_14SourceLocationEN4llvm8ArrayRefIPNS_17ObjCTypeParamDeclEEES1_")
  //</editor-fold>
  private ObjCTypeParamList(type$ptr<?> $this, SourceLocation lAngleLoc, 
      ArrayRef<ObjCTypeParamDecl /*P*/ > typeParams, 
      SourceLocation rAngleLoc) {
    // : TrailingObjects<ObjCTypeParamList, ObjCTypeParamDecl * >(), NumParams(typeParams.size()) 
    //START JInit
    $TrailingObjects();
    this.NumParams = typeParams.size();
    this.$TrailingObjects = TrailingObjectsUtils.$putThisAndShift(this, $this);
    //END JInit
    Unnamed_field.Brackets.Begin = lAngleLoc.getRawEncoding();
    Unnamed_field.Brackets.End = rAngleLoc.getRawEncoding();
    std.copy(typeParams.begin(), typeParams.end(), begin());
  }

/*public:*/
  /// Create a new Objective-C type parameter list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1362,
   FQN="clang::ObjCTypeParamList::create", NM="_ZN5clang17ObjCTypeParamList6createERNS_10ASTContextENS_14SourceLocationEN4llvm8ArrayRefIPNS_17ObjCTypeParamDeclEEES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamList6createERNS_10ASTContextENS_14SourceLocationEN4llvm8ArrayRefIPNS_17ObjCTypeParamDeclEEES3_")
  //</editor-fold>
  public static ObjCTypeParamList /*P*/ create(final ASTContext /*&*/ ctx, 
        SourceLocation lAngleLoc, 
        ArrayRef<ObjCTypeParamDecl /*P*/ > typeParams, 
        SourceLocation rAngleLoc) {
    Object/*void P*/ mem = ctx.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(ObjCTypeParamDecl.class, typeParams.size()), 
        alignOf(ObjCTypeParamList.class));
    return /*NEW_EXPR [System]*//*new (mem)*/ $new_uint_voidPtr(mem, (type$ptr<?> New$Mem)->{
        return new ObjCTypeParamList(New$Mem, new SourceLocation(lAngleLoc), new ArrayRef<ObjCTypeParamDecl /*P*/ >(typeParams), new SourceLocation(rAngleLoc));
     });
  }

  
  /// Iterate through the type parameters in the list.
  /*typedef ObjCTypeParamDecl **iterator*/
//  public final class iterator extends type$ptr<ObjCTypeParamDecl /*P*/ /*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 643,
   FQN="clang::ObjCTypeParamList::begin", NM="_ZN5clang17ObjCTypeParamList5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamList5beginEv")
  //</editor-fold>
  public type$ptr<ObjCTypeParamDecl /*P*/ /*P*/> begin() {
    return getTrailingObjects(ObjCTypeParamDecl /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 645,
   FQN="clang::ObjCTypeParamList::end", NM="_ZN5clang17ObjCTypeParamList3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamList3endEv")
  //</editor-fold>
  public type$ptr<ObjCTypeParamDecl /*P*/ /*P*/> end() {
    return begin().$add(size());
  }

  
  /// Determine the number of type parameters in this list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 648,
   FQN="clang::ObjCTypeParamList::size", NM="_ZNK5clang17ObjCTypeParamList4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamList4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return NumParams;
  }

  
  // Iterate through the type parameters in the list.
  /*typedef ObjCTypeParamDecl *const *const_iterator*/
//  public final class const_iterator extends type$ptr<ObjCTypeParamDecl /*P*/ /*const*/ /*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 653,
   FQN="clang::ObjCTypeParamList::begin", NM="_ZNK5clang17ObjCTypeParamList5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamList5beginEv")
  //</editor-fold>
  public type$ptr<ObjCTypeParamDecl /*P*/ /*const*/ /*P*/> begin$Const() /*const*/ {
    return getTrailingObjects$Const(ObjCTypeParamDecl /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 657,
   FQN="clang::ObjCTypeParamList::end", NM="_ZNK5clang17ObjCTypeParamList3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamList3endEv")
  //</editor-fold>
  public type$ptr<ObjCTypeParamDecl /*P*/ /*const*/ /*P*/> end$Const() /*const*/ {
    return begin$Const().$add(size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 661,
   FQN="clang::ObjCTypeParamList::front", NM="_ZNK5clang17ObjCTypeParamList5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamList5frontEv")
  //</editor-fold>
  public ObjCTypeParamDecl /*P*/ front() /*const*/ {
    assert ($greater_uint(size(), 0)) : "empty Objective-C type parameter list";
    return begin$Const().$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 666,
   FQN="clang::ObjCTypeParamList::back", NM="_ZNK5clang17ObjCTypeParamList4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamList4backEv")
  //</editor-fold>
  public ObjCTypeParamDecl /*P*/ back() /*const*/ {
    assert ($greater_uint(size(), 0)) : "empty Objective-C type parameter list";
    return (end$Const().$sub(1)).$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::getLAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 671,
   FQN="clang::ObjCTypeParamList::getLAngleLoc", NM="_ZNK5clang17ObjCTypeParamList12getLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamList12getLAngleLocEv")
  //</editor-fold>
  public SourceLocation getLAngleLoc() /*const*/ {
    return SourceLocation.getFromRawEncoding(Unnamed_field.Brackets.Begin);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::getRAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 674,
   FQN="clang::ObjCTypeParamList::getRAngleLoc", NM="_ZNK5clang17ObjCTypeParamList12getRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamList12getRAngleLocEv")
  //</editor-fold>
  public SourceLocation getRAngleLoc() /*const*/ {
    return SourceLocation.getFromRawEncoding(Unnamed_field.Brackets.End);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 677,
   FQN="clang::ObjCTypeParamList::getSourceRange", NM="_ZNK5clang17ObjCTypeParamList14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamList14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*/ {
    return new SourceRange(getLAngleLoc(), getRAngleLoc());
  }

  
  /// Gather the default set of type arguments to be substituted for
  /// these type parameters when dealing with an unspecialized type.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamList::gatherDefaultTypeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1373,
   FQN="clang::ObjCTypeParamList::gatherDefaultTypeArgs", NM="_ZNK5clang17ObjCTypeParamList21gatherDefaultTypeArgsERN4llvm15SmallVectorImplINS_8QualTypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamList21gatherDefaultTypeArgsERN4llvm15SmallVectorImplINS_8QualTypeEEE")
  //</editor-fold>
  public void gatherDefaultTypeArgs(final SmallVectorImpl<QualType> /*&*/ typeArgs) /*const*/ {
    typeArgs.reserve(size());
    for (ObjCTypeParamDecl /*P*/ typeParam : /*Deref*/this)  {
      typeArgs.push_back(typeParam.getUnderlyingType());
    }
  }

  /*friend  TrailingObjects<ObjCTypeParamList, ObjCTypeParamDecl *>*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<ObjCTypeParamDecl> iterator() { 
    return new JavaIterator<ObjCTypeParamDecl>(begin(), end()); 
  }

  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == ObjCTypeParamDecl.class;
    return 0;
  }
  
  private final type$ptr<?> $TrailingObjects;
    
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return $TrailingObjects;
  }
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Unnamed_field=" + Unnamed_field // NOI18N
              + ", NumParams=" + NumParams // NOI18N
              + super.toString(); // NOI18N
  }
}
