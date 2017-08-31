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
package org.clang.analysis.domainspecific.ento;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type coreFoundation">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CocoaConventions.cpp -nm=_ZN5clang4ento14coreFoundation13isCFObjectRefENS_8QualTypeE;_ZN5clang4ento14coreFoundation17followsCreateRuleEPKNS_12FunctionDeclE; -static-type=coreFoundation -package=org.clang.analysis.domainspecific.ento")
//</editor-fold>
public final class coreFoundation {

//<editor-fold defaultstate="collapsed" desc="clang::ento::coreFoundation::isCFObjectRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CocoaConventions.cpp", line = 50,
 FQN="clang::ento::coreFoundation::isCFObjectRef", NM="_ZN5clang4ento14coreFoundation13isCFObjectRefENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CocoaConventions.cpp -nm=_ZN5clang4ento14coreFoundation13isCFObjectRefENS_8QualTypeE")
//</editor-fold>
public static boolean isCFObjectRef(QualType T) {
  return cocoa.isRefType(new QualType(T), new StringRef(/*KEEP_STR*/"CF")) // Core Foundation.
     || cocoa.isRefType(new QualType(T), new StringRef(/*KEEP_STR*/"CG")) // Core Graphics.
     || cocoa.isRefType(new QualType(T), new StringRef(/*KEEP_STR*/"DADisk")) // Disk Arbitration API.
     || cocoa.isRefType(new QualType(T), new StringRef(/*KEEP_STR*/"DADissenter"))
     || cocoa.isRefType(new QualType(T), new StringRef(/*KEEP_STR*/"DASessionRef"));
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::coreFoundation::followsCreateRule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CocoaConventions.cpp", line = 91,
 FQN="clang::ento::coreFoundation::followsCreateRule", NM="_ZN5clang4ento14coreFoundation17followsCreateRuleEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CocoaConventions.cpp -nm=_ZN5clang4ento14coreFoundation17followsCreateRuleEPKNS_12FunctionDeclE")
//</editor-fold>
public static boolean followsCreateRule(/*const*/ FunctionDecl /*P*/ fn) {
  // For now, *just* base this on the function name, not on anything else.
  /*const*/ IdentifierInfo /*P*/ ident = fn.getIdentifier();
  if (!(ident != null)) {
    return false;
  }
  StringRef functionName = ident.getName();
  
  char$ptr it = $tryClone(functionName.begin());
  char$ptr start = $tryClone(it);
  char$ptr endI = $tryClone(functionName.end());
  while (true) {
    // Scan for the start of 'create' or 'copy'.
    for (; $noteq_ptr(it, endI); it.$preInc()) {
      // Search for the first character.  It can either be 'C' or 'c'.
      /*char*/byte ch = it.$star();
      if (ch == $$C || ch == $$c) {
        // Make sure this isn't something like 'recreate' or 'Scopy'.
        if (ch == $$c && $noteq_ptr(it, start) && isLetter((it.$sub(1)).$star())) {
          continue;
        }
        
        it.$preInc();
        break;
      }
    }
    
    // Did we hit the end of the string?  If so, we didn't find a match.
    if ($eq_ptr(it, endI)) {
      return false;
    }
    
    // Scan for *lowercase* 'reate' or 'opy', followed by no lowercase
    // character.
    StringRef suffix = functionName.substr(it.$sub(start));
    if (suffix.startswith(/*STRINGREF_STR*/"reate")) {
      it.$inc(5);
    } else if (suffix.startswith(/*STRINGREF_STR*/"opy")) {
      it.$inc(3);
    } else {
      // Keep scanning.
      continue;
    }
    if ($eq_ptr(it, endI) || !isLowercase(it.$star())) {
      return true;
    }
    // If we matched a lowercase character, it isn't the end of the
    // word.  Keep scanning.
  }
}

} // END OF class coreFoundation
