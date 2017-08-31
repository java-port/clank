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
import org.llvm.support.*;
import org.clang.frontend.serialized_diags.SDError;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDErrorCategoryType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp", line = 253,
 FQN="(anonymous namespace)::SDErrorCategoryType", NM="_ZN12_GLOBAL__N_119SDErrorCategoryTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp -nm=_ZN12_GLOBAL__N_119SDErrorCategoryTypeE")
//</editor-fold>
public final class SDErrorCategoryType extends /*public*/ std.error_category implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDErrorCategoryType::name">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp", line = 254,
   FQN="(anonymous namespace)::SDErrorCategoryType::name", NM="_ZNK12_GLOBAL__N_119SDErrorCategoryType4nameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp -nm=_ZNK12_GLOBAL__N_119SDErrorCategoryType4nameEv")
  //</editor-fold>
  @Override public/*private*/ /*const*/String/*char P*/ name() /*const*//* override*/ {
    return "clang.serialized_diags";
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDErrorCategoryType::message">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp", line = 257,
   FQN="(anonymous namespace)::SDErrorCategoryType::message", NM="_ZNK12_GLOBAL__N_119SDErrorCategoryType7messageEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp -nm=_ZNK12_GLOBAL__N_119SDErrorCategoryType7messageEi")
  //</editor-fold>
  @Override public/*private*/ std.string message(int IE) /*const*//* override*/ {
//    SDError E = ((/*static_cast*/SDError)(IE));
    SDError E = SDError.valueOf(IE);
    switch (E) {
     case CouldNotLoad:
      return new std.string(/*KEEP_STR*/"Failed to open diagnostics file");
     case InvalidSignature:
      return new std.string(/*KEEP_STR*/"Invalid diagnostics signature");
     case InvalidDiagnostics:
      return new std.string(/*KEEP_STR*/"Parse error reading diagnostics");
     case MalformedTopLevelBlock:
      return new std.string(/*KEEP_STR*/"Malformed block at top-level of diagnostics");
     case MalformedSubBlock:
      return new std.string(/*KEEP_STR*/"Malformed sub-block in a diagnostic");
     case MalformedBlockInfoBlock:
      return new std.string(/*KEEP_STR*/"Malformed BlockInfo block");
     case MalformedMetadataBlock:
      return new std.string(/*KEEP_STR*/"Malformed Metadata block");
     case MalformedDiagnosticBlock:
      return new std.string(/*KEEP_STR*/"Malformed Diagnostic block");
     case MalformedDiagnosticRecord:
      return new std.string(/*KEEP_STR*/"Malformed Diagnostic record");
     case MissingVersion:
      return new std.string(/*KEEP_STR*/"No version provided in diagnostics");
     case VersionMismatch:
      return new std.string(/*KEEP_STR*/"Unsupported diagnostics version");
     case UnsupportedConstruct:
      return new std.string(/*KEEP_STR*/"Bitcode constructs that are not supported in diagnostics appear");
     case HandlerFailed:
      return new std.string(/*KEEP_STR*/"Generic error occurred while handling a record");
    }
    throw new llvm_unreachable("Unknown error type!");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDErrorCategoryType::~SDErrorCategoryType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp", line = 253,
   FQN="(anonymous namespace)::SDErrorCategoryType::~SDErrorCategoryType", NM="_ZN12_GLOBAL__N_119SDErrorCategoryTypeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp -nm=_ZN12_GLOBAL__N_119SDErrorCategoryTypeD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDErrorCategoryType::SDErrorCategoryType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp", line = 253,
   FQN="(anonymous namespace)::SDErrorCategoryType::SDErrorCategoryType", NM="_ZN12_GLOBAL__N_119SDErrorCategoryTypeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp -nm=_ZN12_GLOBAL__N_119SDErrorCategoryTypeC1Ev")
  //</editor-fold>
  public /*inline*/ SDErrorCategoryType() {
    // : std::error_category() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
