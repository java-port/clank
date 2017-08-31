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

package org.clang.astmatchers.dynamic.ast_matchers.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.ast_type_traits.*;
import org.clang.astmatchers.ast_matchers.*;
import org.clang.astmatchers.ast_matchers.internal.*;
import org.clang.astmatchers.ast_matchers.internal.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.*;
import org.clang.astmatchers.dynamic.ast_matchers.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.internal.impl.*;
import org.clang.astmatchers.ast_matchers.java.AstMatchersFunctionPointers.*;
import org.clang.basic.java.*;
import org.clang.basic.llvm.*;
import org.clang.lex.*;
import org.clang.lex.java.*;
import org.clang.lex.llvm.*;

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::(anonymous namespace)::RegistryMaps">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp", line = 35,
 FQN="clang::ast_matchers::dynamic::(anonymous namespace)::RegistryMaps", NM="_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_112RegistryMapsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_112RegistryMapsE")
//</editor-fold>
public class RegistryMaps implements Destructors.ClassWithDestructor {
/*public:*/
  
  /// \brief Generate a registry map with all the known matchers.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::(anonymous namespace)::RegistryMaps::RegistryMaps">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp", line = 74,
   FQN="clang::ast_matchers::dynamic::(anonymous namespace)::RegistryMaps::RegistryMaps", NM="_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_112RegistryMapsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_112RegistryMapsC1Ev")
  //</editor-fold>
  public RegistryMaps() {
    // : Constructors() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::(anonymous namespace)::RegistryMaps::~RegistryMaps">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp", line = 424,
   FQN="clang::ast_matchers::dynamic::(anonymous namespace)::RegistryMaps::~RegistryMaps", NM="_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_112RegistryMapsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_112RegistryMapsD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::(anonymous namespace)::RegistryMaps::constructors">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp", line = 40,
   FQN="clang::ast_matchers::dynamic::(anonymous namespace)::RegistryMaps::constructors", NM="_ZNK5clang12ast_matchers7dynamic12_GLOBAL__N_112RegistryMaps12constructorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic12_GLOBAL__N_112RegistryMaps12constructorsEv")
  //</editor-fold>
  public /*const*/StringMap</*const*/ MatcherDescriptor /*P*/ > /*&*/ constructors() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::(anonymous namespace)::RegistryMaps::registerMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp", line = 47,
   FQN="clang::ast_matchers::dynamic::(anonymous namespace)::RegistryMaps::registerMatcher", NM="_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_112RegistryMaps15registerMatcherEN4llvm9StringRefEPNS1_8internal17MatcherDescriptorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_112RegistryMaps15registerMatcherEN4llvm9StringRefEPNS1_8internal17MatcherDescriptorE")
  //</editor-fold>
  private void registerMatcher(StringRef MatcherName, 
                 MatcherDescriptor /*P*/ Callback) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  private StringMap</*const*/ MatcherDescriptor /*P*/ > Constructors;
  
  @Override public String toString() {
    return "" + "Constructors=" + Constructors; // NOI18N
  }
}
