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

package org.clang.ast.impl;

import java.util.concurrent.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import static org.clang.ast.impl.TypeStatics.*;

/// The type-property cache.  This is templated so as to be
/// instantiated at an internal type to prevent unnecessary symbol
/// leakage.
/*template <class Private> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::TypePropertyCache">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed instantiation-based separation emulated by $for method*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3242,
 FQN="clang::TypePropertyCache", NM="_ZN5clang17TypePropertyCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17TypePropertyCacheE")
//</editor-fold>
public class TypePropertyCache</*class*/ Private>  {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypePropertyCache::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3244,
   FQN="clang::TypePropertyCache::get", NM="_ZN5clang17TypePropertyCache3getENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17TypePropertyCache3getENS_8QualTypeE")
  //</editor-fold>
  public /*static*/ </*class*/ Private> CachedProperties get(QualType T) {
    return get(T.getTypePtr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypePropertyCache::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3248,
   FQN="clang::TypePropertyCache::get", NM="_ZN5clang17TypePropertyCache3getEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17TypePropertyCache3getEPKNS_4TypeE")
  //</editor-fold>
  public /*static*/ </*class*/ Private> CachedProperties get(/*const*/ Type /*P*/ T) {
    ensure(T);
    return new CachedProperties(T.Unnamed_field.TypeBits.getLinkage(), 
        T.Unnamed_field.TypeBits.hasLocalOrUnnamedType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypePropertyCache::ensure">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3254,
   FQN="clang::TypePropertyCache::ensure", NM="_ZN5clang17TypePropertyCache6ensureEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17TypePropertyCache6ensureEPKNS_4TypeE")
  //</editor-fold>
  public /*static*/ </*class*/ Private> void ensure(/*const*/ Type /*P*/ T) {
    // If the cache is valid, we're okay.
    if (T.Unnamed_field.TypeBits.isCacheValid()) {
      return;
    }
    
    // If this type is non-canonical, ask its canonical type for the
    // relevant information.
    if (!T.isCanonicalUnqualified()) {
      /*const*/ Type /*P*/ CT = T.getCanonicalTypeInternal().getTypePtr();
      ensure(CT);
      T.Unnamed_field.TypeBits.CacheValid = true;
      T.Unnamed_field.TypeBits.CachedLinkage = $uint2uint_3bits(CT.Unnamed_field.TypeBits.CachedLinkage);
      T.Unnamed_field.TypeBits.CachedLocalOrUnnamed = CT.Unnamed_field.TypeBits.CachedLocalOrUnnamed;
      return;
    }
    
    // Compute the cached properties and then set the cache.
    CachedProperties Result = computeCachedProperties(T);
    T.Unnamed_field.TypeBits.CacheValid = true;
    T.Unnamed_field.TypeBits.CachedLinkage = $uint2uint_3bits(Result.getLinkage().getValue());
    T.Unnamed_field.TypeBits.CachedLocalOrUnnamed = Result.hasLocalOrUnnamedType();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final ConcurrentMap<Class<?>, TypePropertyCache> $INSTANCES = new ConcurrentHashMap<>(16);
  
  public static TypePropertyCache $for(Class<?> key) { return $INSTANCES.computeIfAbsent(key, (clazz) -> new TypePropertyCache()); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
