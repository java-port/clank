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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.frontend.*;


/// \brief A PCHContainerGenerator that writes out the PCH to a flat file.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawPCHContainerGenerator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp", line = 29,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp", old_line = 25,
 FQN="(anonymous namespace)::RawPCHContainerGenerator", NM="_ZN12_GLOBAL__N_124RawPCHContainerGeneratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_124RawPCHContainerGeneratorE")
//</editor-fold>
public class RawPCHContainerGenerator extends /*public*/ ASTConsumer implements Destructors.ClassWithDestructor {
  private std.shared_ptr<PCHBuffer> Buffer;
  private std.unique_ptr<raw_pwrite_stream> OS;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawPCHContainerGenerator::RawPCHContainerGenerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp", line = 34,
   FQN="(anonymous namespace)::RawPCHContainerGenerator::RawPCHContainerGenerator", NM="_ZN12_GLOBAL__N_124RawPCHContainerGeneratorC1ESt10unique_ptrIN4llvm17raw_pwrite_streamESt14default_deleteIS3_EESt10shared_ptrIN5clang9PCHBufferEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_124RawPCHContainerGeneratorC1ESt10unique_ptrIN4llvm17raw_pwrite_streamESt14default_deleteIS3_EESt10shared_ptrIN5clang9PCHBufferEE")
  //</editor-fold>
  public RawPCHContainerGenerator(std.unique_ptr<raw_pwrite_stream> OS, 
      std.shared_ptr<PCHBuffer> Buffer) {
    // : ASTConsumer(), Buffer(std::move(Buffer)), OS(std::move(OS)) 
    //START JInit
    super();
    this.Buffer = new std.shared_ptr<PCHBuffer>(JD$Move.INSTANCE, std.move(Buffer));
    this.OS = new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, std.move(OS));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawPCHContainerGenerator::~RawPCHContainerGenerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp", line = 38,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp", old_line = 34,
   FQN="(anonymous namespace)::RawPCHContainerGenerator::~RawPCHContainerGenerator", NM="_ZN12_GLOBAL__N_124RawPCHContainerGeneratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_124RawPCHContainerGeneratorD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*//* = default*/ {
    //START JDestroy
    OS.$destroy();
    Buffer.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawPCHContainerGenerator::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp", line = 40,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp", old_line = 36,
   FQN="(anonymous namespace)::RawPCHContainerGenerator::HandleTranslationUnit", NM="_ZN12_GLOBAL__N_124RawPCHContainerGenerator21HandleTranslationUnitERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_124RawPCHContainerGenerator21HandleTranslationUnitERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(ASTContext /*&*/ Ctx)/* override*/ {
    if (Buffer.$arrow().IsComplete) {
      // Make sure it hits disk now.
      OS.$star().$out(Buffer.$arrow().Data);
      OS.$arrow().flush();
    }
    // Free the space of the temporary buffer.
    SmallString Empty/*J*/= new SmallString(0);
    Buffer.$arrow().Data.$assignMove(std.move(Empty));
  }

  
  @Override public String toString() {
    return "" + "Buffer=" + Buffer // NOI18N
              + ", OS=" + OS // NOI18N
              + super.toString(); // NOI18N
  }
}
