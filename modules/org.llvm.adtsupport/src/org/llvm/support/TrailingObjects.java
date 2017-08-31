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

package org.llvm.support;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;

// end namespace trailing_objects_internal

// Finally, the main type defined in this file, the one intended for users...

/// See the file comment for details on the usage of the
/// TrailingObjects type.
/*template <typename BaseTy, typename ... TrailingTys> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::TrailingObjects">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TrailingObjects.h", line = 230,
 FQN="llvm::TrailingObjects", NM="_ZN4llvm15TrailingObjectsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN4llvm15TrailingObjectsE")
//</editor-fold>
public interface TrailingObjects</*typename*/ BaseTy, /*typename*/ /*...*/ TrailingTys> 
  extends /*private*/ TrailingObjectsImpl<BaseTy, TrailingTys> {
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public default type$ptr<?> $TrailingObjects() {
    return null;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public default int getTrailingObjects$Offset(Class<?> clazz) {
    throw new UnsupportedOperationException("Why Not implemented in " + this.getClass() + "? Or derive from TrailingObjectsJavaBase");
  }

  /// OverloadToken's purpose is to allow specifying function overloads
  /// for different types, without actually taking the types as
  /// parameters. (Necessary because member function templates cannot
  /// be specialized, so overloads must be used instead of
  /// specialization.)
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::trailing_objects_internal::TrailingObjectsBase::OverloadToken">
  @Converted(kind = Converted.Kind.MANUAL,
          source = "${LLVM_SRC}/llvm/include/llvm/Support/TrailingObjects.h", line = 88,
          FQN = "llvm::trailing_objects_internal::TrailingObjectsBase::OverloadToken", NM = "_ZN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenE",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenE")
  //</editor-fold>
  /*protected:*/
  public static class/*struct*/ OverloadToken</*typename*/ T> {
    // in Java we can't use this technique since there will be the same erasure for overloads
    public static class NestedNameSpecifierLoc {
      public static final NestedNameSpecifierLoc INSTANCE = new NestedNameSpecifierLoc();
    };
    public static class NamedDecl {
      public static final NamedDecl INSTANCE = new NamedDecl();
    };
    public static class MemberExprNameQualifier {
      public static final MemberExprNameQualifier INSTANCE = new MemberExprNameQualifier();
    };
    public static class ASTTemplateKWAndArgsInfo {
      public static final ASTTemplateKWAndArgsInfo INSTANCE = new ASTTemplateKWAndArgsInfo();
    };
  };
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static class/*struct*/ OverloadTokenUInt { 
    public static final OverloadTokenUInt INSTANCE = new OverloadTokenUInt();
  }
  
  //JAVA: using TrailingObjectsImpl<AlignmentCalcHelper<TrailingTys...>.Alignment, BaseTy, TrailingObjects<BaseTy, TrailingTys...>, BaseTy, TrailingTys...>::getTrailingObjectsImpl;
  
  /*public:*/
  // make this (privately inherited) class public.
  //JAVA: using TrailingObjectsImpl<AlignmentCalcHelper<TrailingTys...>.Alignment, BaseTy, TrailingObjects<BaseTy, TrailingTys...>, BaseTy, TrailingTys...>::OverloadToken;

  /// Returns a pointer to the trailing object array of the given type
  /// (which must be one of those specified in the class template). The
  /// array may have zero or more elements in it.
  /*template <typename T> TEMPLATE*/
  /// Returns a pointer to the trailing object array of the given type
  /// (which must be one of those specified in the class template). The
  /// array may have zero or more elements in it.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TrailingObjects::getTrailingObjects">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TrailingObjects.h", line = 299,
   FQN="llvm::TrailingObjects::getTrailingObjects", NM="Tpl__ZNK4llvm15TrailingObjects18getTrailingObjectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=Tpl__ZNK4llvm15TrailingObjects18getTrailingObjectsEv")
  //</editor-fold>
  public default/*interface*/ </*typename*/ T> type$ptr</*const*/ T /*P*/> getTrailingObjects$Const(Class<T> clazz) /*const*/ {
    return getTrailingObjects(clazz);
  }

  
  /// Returns a pointer to the trailing object array of the given type
  /// (which must be one of those specified in the class template). The
  /// array may have zero or more elements in it.
  /*template <typename T> TEMPLATE*/
  /// Returns a pointer to the trailing object array of the given type
  /// (which must be one of those specified in the class template). The
  /// array may have zero or more elements in it.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TrailingObjects::getTrailingObjects">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TrailingObjects.h", line = 311,
   FQN="llvm::TrailingObjects::getTrailingObjects", NM="Tpl__ZN4llvm15TrailingObjects18getTrailingObjectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=Tpl__ZN4llvm15TrailingObjects18getTrailingObjectsEv")
  //</editor-fold>
  public default/*interface*/ </*typename*/ T> type$ptr</*const*/ T /*P*/> getTrailingObjects(Class<T> clazz) {
    int shift = getTrailingObjects$Offset(clazz);
    return (type$ptr<T>)(shift == 0 ? $TrailingObjects() : Native.$toConst($TrailingObjects().$add(shift)));
  }

    /// Returns the size of the trailing data, if an object were
  /// allocated with the given counts (The counts are in the same order
  /// as the template arguments). This does not include the size of the
  /// base object.  The template arguments must be the same as those
  /// used in the class; they are supplied here redundantly only so
  /// that it's clear what the counts are counting in callers.
  /*template <typename ... Tys> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TrailingObjects::additionalSizeToAlloc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TrailingObjects.h", line = 326,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TrailingObjects.h", old_line = 325,
   FQN="llvm::TrailingObjects::additionalSizeToAlloc", NM="Tpl__ZN4llvm15TrailingObjects21additionalSizeToAllocEDpNS_25trailing_objects_internal17ExtractSecondTypeIT0_jE4typeER_ZTSNSt9enable_ifIXsr3std7is_sameIN4llvm15TrailingObjects3FooIJDpT0_EEENS2_IJDpT_EEEEE5valueEjE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=Tpl__ZN4llvm15TrailingObjects21additionalSizeToAllocEDpNS_25trailing_objects_internal17ExtractSecondTypeIT0_jE4typeER_ZTSNSt9enable_ifIXsr3std7is_sameIN4llvm15TrailingObjects3FooIJDpT0_EEENS2_IJDpT_EEEEE5valueEjE4typeE")
  //</editor-fold>
  public static </*typename*/ /*...*/ Tys> /*std::enable_if<std::is_same<Foo<TrailingTys...>, Foo<Tys...> >::value, int>::type*//*size_t*/ 
        int additionalSizeToAlloc$Same(Class<Tys> clazz, int Counts) {
    // JAVA: in Java we don't add any padding and return the count as is
    return Counts;
  }
        
  
  /// Returns the total size of an object if it were allocated with the
  /// given trailing object counts. This is the same as
  /// additionalSizeToAlloc, except it *does* include the size of the base
  /// object.
  /*template <typename ... Tys> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TrailingObjects::totalSizeToAlloc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, // for allocating size for 'Counts' POD of Tys class
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TrailingObjects.h", line = 339,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TrailingObjects.h", old_line = 338,
   FQN="llvm::TrailingObjects::totalSizeToAlloc", NM="Tpl__ZN4llvm15TrailingObjects16totalSizeToAllocEDpNS_25trailing_objects_internal17ExtractSecondTypeIT0_jE4typeER_ZTSNSt9enable_ifIXsr3std7is_sameIN4llvm15TrailingObjects3FooIJDpT0_EEENS2_IJDpT_EEEEE5valueEjE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=Tpl__ZN4llvm15TrailingObjects16totalSizeToAllocEDpNS_25trailing_objects_internal17ExtractSecondTypeIT0_jE4typeER_ZTSNSt9enable_ifIXsr3std7is_sameIN4llvm15TrailingObjects3FooIJDpT0_EEENS2_IJDpT_EEEEE5valueEjE4typeE")
  //</editor-fold>
  public /*interface*/ static  </*typename*/ /*...*/ T1> /*std::enable_if<std::is_same<Foo<TrailingTys...>, Foo<Tys...> >::value, int>::type*//*size_t*/
        int totalSizeToAlloc$Same(Class<T1> clazz1, int Count1) {
    // JAVA: in Java we don't add any padding and return the count as is
    return 1/*JAVA object itself*/ + Count1;
  }

  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  public /*interface*/ static  </*typename*/ /*...*/ T1,T2> /*std::enable_if<std::is_same<Foo<TrailingTys...>, Foo<Tys...> >::value, int>::type*//*size_t*/
        int totalSizeToAlloc$Same(Class<T1> clazz1, Class<T2> clazz2, int Count1, int Count2) {
    // JAVA: in Java we don't add any padding and return the count as is
    return 1/*JAVA object itself*/ + Count1 + Count2;
  }

 @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  public /*interface*/ static  </*typename*/ /*...*/ T1,T2,T3> /*std::enable_if<std::is_same<Foo<TrailingTys...>, Foo<Tys...> >::value, int>::type*//*size_t*/
        int totalSizeToAlloc$Same(Class<T1> clazz1, Class<T2> clazz2, Class<T3> clazz3, int Count1, int Count2, int Count3) {
    // JAVA: in Java we don't add any padding and return the count as is
    return 1/*JAVA object itself*/ + Count1 + Count2 + Count3;
  }

  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  public /*interface*/ static  </*typename*/ /*...*/ T1,T2,T3,T4> /*std::enable_if<std::is_same<Foo<TrailingTys...>, Foo<Tys...> >::value, int>::type*//*size_t*/
        int totalSizeToAlloc$Same(Class<T1> clazz1, Class<T2> clazz2, Class<T3> clazz3, Class<T4> clazz4, int Count1, int Count2, int Count3, int Count4) {
    // JAVA: in Java we don't add any padding and return the count as is
    return 1/*JAVA object itself*/ + Count1 + Count2 + Count3 + Count4;
  }

  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  public /*interface*/ static  </*typename*/ /*...*/ T1,T2,T3,T4,T5> /*std::enable_if<std::is_same<Foo<TrailingTys...>, Foo<Tys...> >::value, int>::type*//*size_t*/
        int totalSizeToAlloc$Same(Class<T1> clazz1, Class<T2> clazz2, Class<T3> clazz3, Class<T4> clazz4, Class<T5> clazz5, int Count1, int Count2, int Count3, int Count4, int Count5) {
    // JAVA: in Java we don't add any padding and return the count as is
    return 1/*JAVA object itself*/ + Count1 + Count2 + Count3 + Count4 + Count5;
  }

  public default void $destroy$TrailingObjects() {
    // do nothing
  }  
}
