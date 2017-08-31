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

package org.llvm.ir;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::AssemblyAnnotationWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/AssemblyAnnotationWriter.h", line = 28,
 FQN="llvm::AssemblyAnnotationWriter", NM="_ZN4llvm24AssemblyAnnotationWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm24AssemblyAnnotationWriterE")
//</editor-fold>
public class AssemblyAnnotationWriter implements Destructors.ClassWithDestructor {
/*public:*/
  
  // Make virtual table appear in this compilation unit.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssemblyAnnotationWriter::~AssemblyAnnotationWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 51,
   FQN="llvm::AssemblyAnnotationWriter::~AssemblyAnnotationWriter", NM="_ZN4llvm24AssemblyAnnotationWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm24AssemblyAnnotationWriterD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// emitFunctionAnnot - This may be implemented to emit a string right before
  /// the start of a function.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssemblyAnnotationWriter::emitFunctionAnnot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/AssemblyAnnotationWriter.h", line = 34,
   FQN="llvm::AssemblyAnnotationWriter::emitFunctionAnnot", NM="_ZN4llvm24AssemblyAnnotationWriter17emitFunctionAnnotEPKNS_8FunctionERNS_21formatted_raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm24AssemblyAnnotationWriter17emitFunctionAnnotEPKNS_8FunctionERNS_21formatted_raw_ostreamE")
  //</editor-fold>
  public /*virtual*/ void emitFunctionAnnot(/*const*/ Function /*P*/ $Prm0, 
                   final formatted_raw_ostream /*&*/ $Prm1) {
  }

  
  /// emitBasicBlockStartAnnot - This may be implemented to emit a string right
  /// after the basic block label, but before the first instruction in the
  /// block.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssemblyAnnotationWriter::emitBasicBlockStartAnnot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/AssemblyAnnotationWriter.h", line = 40,
   FQN="llvm::AssemblyAnnotationWriter::emitBasicBlockStartAnnot", NM="_ZN4llvm24AssemblyAnnotationWriter24emitBasicBlockStartAnnotEPKNS_10BasicBlockERNS_21formatted_raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm24AssemblyAnnotationWriter24emitBasicBlockStartAnnotEPKNS_10BasicBlockERNS_21formatted_raw_ostreamE")
  //</editor-fold>
  public /*virtual*/ void emitBasicBlockStartAnnot(/*const*/ BasicBlock /*P*/ $Prm0, 
                          final formatted_raw_ostream /*&*/ $Prm1) {
  }

  
  /// emitBasicBlockEndAnnot - This may be implemented to emit a string right
  /// after the basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssemblyAnnotationWriter::emitBasicBlockEndAnnot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/AssemblyAnnotationWriter.h", line = 46,
   FQN="llvm::AssemblyAnnotationWriter::emitBasicBlockEndAnnot", NM="_ZN4llvm24AssemblyAnnotationWriter22emitBasicBlockEndAnnotEPKNS_10BasicBlockERNS_21formatted_raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm24AssemblyAnnotationWriter22emitBasicBlockEndAnnotEPKNS_10BasicBlockERNS_21formatted_raw_ostreamE")
  //</editor-fold>
  public /*virtual*/ void emitBasicBlockEndAnnot(/*const*/ BasicBlock /*P*/ $Prm0, 
                        final formatted_raw_ostream /*&*/ $Prm1) {
  }

  
  /// emitInstructionAnnot - This may be implemented to emit a string right
  /// before an instruction is emitted.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssemblyAnnotationWriter::emitInstructionAnnot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/AssemblyAnnotationWriter.h", line = 52,
   FQN="llvm::AssemblyAnnotationWriter::emitInstructionAnnot", NM="_ZN4llvm24AssemblyAnnotationWriter20emitInstructionAnnotEPKNS_11InstructionERNS_21formatted_raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm24AssemblyAnnotationWriter20emitInstructionAnnotEPKNS_11InstructionERNS_21formatted_raw_ostreamE")
  //</editor-fold>
  public /*virtual*/ void emitInstructionAnnot(/*const*/ Instruction /*P*/ $Prm0, 
                      final formatted_raw_ostream /*&*/ $Prm1) {
  }

  
  /// printInfoComment - This may be implemented to emit a comment to the
  /// right of an instruction or global value.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssemblyAnnotationWriter::printInfoComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/AssemblyAnnotationWriter.h", line = 57,
   FQN="llvm::AssemblyAnnotationWriter::printInfoComment", NM="_ZN4llvm24AssemblyAnnotationWriter16printInfoCommentERKNS_5ValueERNS_21formatted_raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm24AssemblyAnnotationWriter16printInfoCommentERKNS_5ValueERNS_21formatted_raw_ostreamE")
  //</editor-fold>
  public /*virtual*/ void printInfoComment(final /*const*/ Value /*&*/ $Prm0, final formatted_raw_ostream /*&*/ $Prm1) {
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AssemblyAnnotationWriter::AssemblyAnnotationWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/AssemblyAnnotationWriter.h", line = 28,
   FQN="llvm::AssemblyAnnotationWriter::AssemblyAnnotationWriter", NM="_ZN4llvm24AssemblyAnnotationWriterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp -nm=_ZN4llvm24AssemblyAnnotationWriterC1Ev")
  //</editor-fold>
  public /*inline*/ AssemblyAnnotationWriter() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
