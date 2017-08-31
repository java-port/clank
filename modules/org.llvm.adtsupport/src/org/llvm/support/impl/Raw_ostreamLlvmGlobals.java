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
package org.llvm.support.impl;

import org.clank.java.std;
import static org.clank.java.std_defines.STDERR_FILENO;
import org.clank.support.*;
import static org.clank.support.literal_constants.$MINUS;
import org.llvm.adt.StringRef;
import org.llvm.support.raw_fd_ostream;
import org.llvm.support.raw_null_ostream;
import org.llvm.support.raw_ostream;
import org.llvm.support.sys.fs;


//<editor-fold defaultstate="collapsed" desc="static type Raw_ostreamLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.support.impl.Raw_ostreamLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm4errsEv;_ZN4llvm4outsEv;_ZN4llvm5nullsEv; -static-type=Raw_ostreamLlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class Raw_ostreamLlvmGlobals {


/// This returns a reference to a raw_ostream for standard output. Use it like:
/// outs() << "foo" << "bar";

//===----------------------------------------------------------------------===//
//  outs(), errs(), nulls()
//===----------------------------------------------------------------------===//

/// outs() - This returns a reference to a raw_ostream for standard output.
/// Use it like: outs() << "foo" << "bar";
//<editor-fold defaultstate="collapsed" desc="llvm::outs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 718,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 720,
 FQN="llvm::outs", NM="_ZN4llvm4outsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm4outsEv")
//</editor-fold>
public static raw_ostream /*&*/ outs() {
  // Set buffer settings to model stdout behavior.  Delete the file descriptor
  // when the program exits, forcing error detection.  This means that if you
  // ever call outs(), you can't open another raw_fd_ostream on stdout, as we'll
  // close stdout twice and print an error the second time.
  final/*static*/ raw_fd_ostream S = outs$$.S;
  assert (!outs$$.EC.$bool());
  return S;
}
private static final class outs$$ {
  private final static std.error_code EC/*J*/= new std.error_code();
  static final/*static*/ raw_fd_ostream S;
  static {
    S/*J*/= new raw_fd_ostream(new StringRef(/*KEEP_STR*/$MINUS), EC, fs.OpenFlags.F_None);
  }
}


/// This returns a reference to a raw_ostream for standard error. Use it like:
/// errs() << "foo" << "bar";

/// errs() - This returns a reference to a raw_ostream for standard error.
/// Use it like: errs() << "foo" << "bar";
//<editor-fold defaultstate="collapsed" desc="llvm::errs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 731,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 732,
 FQN="llvm::errs", NM="_ZN4llvm4errsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm4errsEv")
//</editor-fold>
public static raw_ostream /*&*/ errs() {
  // Set standard error to be unbuffered by default.
  return errs$$.ERRS;
}

private static final class errs$$ {
  // Set standard error to be unbuffered by default.
  private static final raw_ostream ERRS/*J*/= new raw_fd_ostream(STDERR_FILENO, false, true);
}

/// This returns a reference to a raw_ostream which simply discards output.

/// nulls() - This returns a reference to a raw_ostream which discards output.
//<editor-fold defaultstate="collapsed" desc="llvm::nulls">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 738,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 739,
 FQN="llvm::nulls", NM="_ZN4llvm5nullsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm5nullsEv")
//</editor-fold>
public static raw_ostream /*&*/ nulls() {
  return nulls$$.NULLS;
}
private static final class nulls$$ {
  private static final raw_ostream NULLS/*J*/= new raw_null_ostream();
}

} // END OF class Raw_ostreamLlvmGlobals
