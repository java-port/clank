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
package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.codegen.*;
import org.clang.frontend.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenActionStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZL15GetOutputStreamRN5clang16CompilerInstanceEN4llvm9StringRefENS_13BackendActionE;_ZL22ConvertBackendLocationRKN4llvm12SMDiagnosticERN5clang13SourceManagerE;_ZL27BitcodeInlineAsmDiagHandlerRKN4llvm12SMDiagnosticEPvj; -static-type=CodeGenActionStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CodeGenActionStatics {


/// ConvertBackendLocation - Convert a location in a temporary llvm::SourceMgr
/// buffer to be a valid FullSourceLoc.
//<editor-fold defaultstate="collapsed" desc="ConvertBackendLocation">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 267,
 FQN="ConvertBackendLocation", NM="_ZL22ConvertBackendLocationRKN4llvm12SMDiagnosticERN5clang13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZL22ConvertBackendLocationRKN4llvm12SMDiagnosticERN5clang13SourceManagerE")
//</editor-fold>
public static FullSourceLoc ConvertBackendLocation(final /*const*/ SMDiagnostic /*&*/ D, 
                      final SourceManager /*&*/ CSM) {
  std.unique_ptr<MemoryBuffer> CBuf = null;
  try {
    // Get both the clang and llvm source managers.  The location is relative to
    // a memory buffer that the LLVM Source Manager is handling, we need to add
    // a copy to the Clang source manager.
    final /*const*/ SourceMgr /*&*/ LSM = /*Deref*/D.getSourceMgr();
    
    // We need to copy the underlying LLVM memory buffer because llvm::SourceMgr
    // already owns its one and clang::SourceManager wants to own its one.
    /*const*/ MemoryBuffer /*P*/ LBuf = LSM.getMemoryBuffer(LSM.FindBufferContainingLoc(D.getLoc()));
    
    // Create the copy and transfer ownership to clang::SourceManager.
    // TODO: Avoid copying files into memory.
    CBuf = MemoryBuffer.getMemBufferCopy(LBuf.getBuffer(), 
        new Twine(LBuf.getBufferIdentifier()));
    // FIXME: Keep a file ID map instead of creating new IDs for each location.
    /*FileID*/int $FID = CSM.createFileID(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(CBuf)));
    FileID FID = FileID.getFromRawEncoding($FID);
    
    // Translate the offset into the file.
    /*uint*/int Offset = D.getLoc().getPointer().$sub(LBuf.getBufferStart());
    SourceLocation NewLoc = CSM.getLocForStartOfFile(/*NO_COPY*/FID).getLocWithOffset(Offset);
    return new FullSourceLoc(/*NO_COPY*/NewLoc, CSM);
  } finally {
    if (CBuf != null) { CBuf.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="GetOutputStream">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 695,
 FQN="GetOutputStream", NM="_ZL15GetOutputStreamRN5clang16CompilerInstanceEN4llvm9StringRefENS_13BackendActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZL15GetOutputStreamRN5clang16CompilerInstanceEN4llvm9StringRefENS_13BackendActionE")
//</editor-fold>
public static std.unique_ptr<raw_pwrite_stream> GetOutputStream(final CompilerInstance /*&*/ CI, StringRef InFile, BackendAction Action) {
  switch (Action) {
   case Backend_EmitAssembly:
    return CI.createDefaultOutputFile(false, new StringRef(InFile), new StringRef(/*KEEP_STR*/$s));
   case Backend_EmitLL:
    return CI.createDefaultOutputFile(false, new StringRef(InFile), new StringRef(/*KEEP_STR*/$ll));
   case Backend_EmitBC:
    return CI.createDefaultOutputFile(true, new StringRef(InFile), new StringRef(/*KEEP_STR*/"bc"));
   case Backend_EmitNothing:
    return new std.unique_ptr<raw_pwrite_stream>(JD$NullPtr.INSTANCE, null);
   case Backend_EmitMCNull:
    return CI.createNullOutputFile();
   case Backend_EmitObj:
    return CI.createDefaultOutputFile(true, new StringRef(InFile), new StringRef(/*KEEP_STR*/$o));
  }
  throw new llvm_unreachable("Invalid action!");
}

//<editor-fold defaultstate="collapsed" desc="BitcodeInlineAsmDiagHandler">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 763,
 FQN="BitcodeInlineAsmDiagHandler", NM="_ZL27BitcodeInlineAsmDiagHandlerRKN4llvm12SMDiagnosticEPvj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZL27BitcodeInlineAsmDiagHandlerRKN4llvm12SMDiagnosticEPvj")
//</editor-fold>
public static void BitcodeInlineAsmDiagHandler(final /*const*/ SMDiagnostic /*&*/ SM, 
                           Object/*void P*/ Context, 
                           /*uint*/int LocCookie) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SM.print((/*const*/char$ptr/*char P*/ )null, llvm.errs());
    
    DiagnosticsEngine /*P*/ Diags = ((/*static_cast*/DiagnosticsEngine /*P*/ )(Context));
    /*uint*/int DiagID;
    switch (SM.getKind()) {
     case DK_Error:
      DiagID = diag.err_fe_inline_asm;
      break;
     case DK_Warning:
      DiagID = diag.warn_fe_inline_asm;
      break;
     case DK_Note:
      DiagID = diag.note_fe_inline_asm;
      break;
     default:
       // JAVA
       assert false : "unexpected " + SM.getKind();
       DiagID = -1;
       break;
    }
    
    $c$.track(Diags.Report(DiagID)).AddString(new StringRef(/*KEEP_STR*/"cannot compile inline asm")); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

} // END OF class CodeGenActionStatics
