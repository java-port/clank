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
package org.clang.basic.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;

import static org.clang.basic.VersionTuple.*;


//<editor-fold defaultstate="collapsed" desc="static type ObjCRuntimeClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/ObjCRuntime.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamERKNS_11ObjCRuntimeE; -static-type=ObjCRuntimeClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class ObjCRuntimeClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/ObjCRuntime.cpp", line = 28,
 FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamERKNS_11ObjCRuntimeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/ObjCRuntime.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamERKNS_11ObjCRuntimeE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_ObjCRuntime$C(raw_ostream /*&*/ out, /*const*/ ObjCRuntime /*&*/ value) {
  switch (value.getKind()) {
   case MacOSX:
    out.$out(/*KEEP_STR*/"macosx");
    break;
   case FragileMacOSX:
    out.$out(/*KEEP_STR*/"macosx-fragile");
    break;
   case iOS:
    out.$out(/*KEEP_STR*/"ios");
    break;
   case WatchOS:
    out.$out(/*KEEP_STR*/"watchos");
    break;
   case GNUstep:
    out.$out(/*KEEP_STR*/"gnustep");
    break;
   case GCC:
    out.$out(/*KEEP_STR*/"gcc");
    break;
   case ObjFW:
    out.$out(/*KEEP_STR*/"objfw");
    break;
  }
  if ($greater_VersionTuple$C(value.getVersion(), new VersionTuple(0))) {
   $out_raw_ostream_VersionTuple$C(out.$out_char($$MINUS), value.getVersion());
  }
  return out;
}

} // END OF class ObjCRuntimeClangGlobals
