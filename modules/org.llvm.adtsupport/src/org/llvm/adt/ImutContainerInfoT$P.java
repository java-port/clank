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

package org.llvm.adt;

import java.util.IdentityHashMap;
import org.clank.support.*;
import static org.clank.java.std.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// ImutContainerInfo - Specialization for pointer values to treat pointers
///  as references to unique objects.  Pointers are thus compared by
///  their addresses.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ImutContainerInfo<type-parameter-0-0 * >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 934,
 FQN="llvm::ImutContainerInfo<type-parameter-0-0 * >", NM="_ZN4llvm17ImutContainerInfoIPT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImutContainerInfoIPT_EE")
//</editor-fold>
public class/*struct*/ ImutContainerInfoT$P</*typename*/ T>  extends /*public*/ ImutProfileInfoT$P<T /*P*/ > implements ImutAVLTreeInfoPtrBoolPtr<T, T> {
  /*typedef typename ImutProfileInfo<T *>::value_type value_type*/
//  public final class value_type extends  ImutProfileInfo.value_type<T /*P*/ >{ };
  /*typedef typename ImutProfileInfo<T *>::value_type_ref value_type_ref*/
//  public final class value_type_ref extends T /*P*/{ };
  /*typedef value_type key_type*/
//  public final class key_type extends  ImutProfileInfo.value_type<T /*P*/ >{ };
  /*typedef value_type_ref key_type_ref*/
//  public final class key_type_ref extends T /*P*/{ };
  /*typedef bool data_type*/;
  /*typedef bool data_type_ref*/;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private final Compare<T> $PtrsComparator;

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public ImutContainerInfoT$P(Compare<T> $PtrsComparator) {
    if ($PtrsComparator == null) {
      $PtrsComparator = new RegisteringPtrsComparator<>();
    }
    this.$PtrsComparator = $PtrsComparator;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutContainerInfo<type-parameter-0-0 * >::KeyOfValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 943,
   FQN="llvm::ImutContainerInfo<type-parameter-0-0 * >::KeyOfValue", NM="_ZN4llvm17ImutContainerInfoIPT_E10KeyOfValueENS_15ImutProfileInfoIS2_E14value_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImutContainerInfoIPT_E10KeyOfValueENS_15ImutProfileInfoIS2_E14value_type_refE")
  //</editor-fold>
  public /*interface*/ T /*P*/ KeyOfValue(T /*P*/ D) {
    return D;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutContainerInfo<type-parameter-0-0 * >::DataOfValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 944,
   FQN="llvm::ImutContainerInfo<type-parameter-0-0 * >::DataOfValue", NM="_ZN4llvm17ImutContainerInfoIPT_E11DataOfValueENS_15ImutProfileInfoIS2_E14value_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImutContainerInfoIPT_E11DataOfValueENS_15ImutProfileInfoIS2_E14value_type_refE")
  //</editor-fold>
  public /*interface*/ boolean DataOfValue(T /*P*/ $Prm0) {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutContainerInfo<type-parameter-0-0 * >::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 946,
   FQN="llvm::ImutContainerInfo<type-parameter-0-0 * >::isEqual", NM="_ZN4llvm17ImutContainerInfoIPT_E7isEqualENS_15ImutProfileInfoIS2_E14value_type_refES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImutContainerInfoIPT_E7isEqualENS_15ImutProfileInfoIS2_E14value_type_refES6_")
  //</editor-fold>
  public /*interface*/ boolean isEqual(T /*P*/ LHS, T /*P*/ RHS) {
    if (LHS == RHS) return true;
    return !isLess(LHS, RHS) && !isLess(RHS, LHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutContainerInfo<type-parameter-0-0 * >::isLess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 948,
   FQN="llvm::ImutContainerInfo<type-parameter-0-0 * >::isLess", NM="_ZN4llvm17ImutContainerInfoIPT_E6isLessENS_15ImutProfileInfoIS2_E14value_type_refES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImutContainerInfoIPT_E6isLessENS_15ImutProfileInfoIS2_E14value_type_refES6_")
  //</editor-fold>
  public /*interface*/ boolean isLess(T /*P*/ LHS, T /*P*/ RHS) {
    if (LHS == RHS) return false;
    return $PtrsComparator.$less(LHS, RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutContainerInfo<type-parameter-0-0 * >::isDataEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 950,
   FQN="llvm::ImutContainerInfo<type-parameter-0-0 * >::isDataEqual", NM="_ZN4llvm17ImutContainerInfoIPT_E11isDataEqualEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImutContainerInfoIPT_E11isDataEqualEbb")
  //</editor-fold>
  public /*interface*/ boolean isDataEqual(boolean $Prm0, boolean $Prm1) {
    return true;
  }

  
  private static class RegisteringPtrsComparator<T> implements Compare<T> {
    
    private final IdentityHashMap<T, Integer> registry = new IdentityHashMap<>();
    
    private int counter = 0;
    private boolean printedWarning = false;

    @Override
    public boolean compare(T a, T b) {
      assert !(a instanceof void$ptr) : "must not be " + NativeTrace.getIdentityStr(a);
      int hash_a = System.identityHashCode(a);
      int hash_b = System.identityHashCode(b);
      if (hash_a == hash_b) {
        if (!printedWarning) {
          llvm.errs().$out("Registering pointers comparator is used! Please, think if you can provide specialized one!\n");
          printedWarning = true;
        }
        Integer aId = registry.get(a);
        if (aId == null) {
          aId = counter++;
          registry.put(a, aId);
        }
        hash_a = aId;
        Integer bId = registry.get(b);
        if (bId == null) {
          bId = counter++;
          registry.put(b, bId);
        }
        hash_b = bId;
      }
      return hash_a < hash_b;
    }
  }
}
