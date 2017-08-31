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

package org.llvm.support;

import org.clank.support.*;
import org.llvm.support.*;
import static org.llvm.support.impl.PrettyStackTraceStatics.*;


/// PrettyStackTraceEntry - This class is used to represent a frame of the
/// "pretty" stack trace that is dumped when a program crashes. You can define
/// subclasses of this and declare them on the program stack: when they are
/// constructed and destructed, they will add their symbolic frames to a
/// virtual stack trace.  This gets dumped out if the program crashes.
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/PrettyStackTrace.h", line = 31,
 FQN = "llvm::PrettyStackTraceEntry", NM = "_ZN4llvm21PrettyStackTraceEntryE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm21PrettyStackTraceEntryE")
//</editor-fold>
public abstract class PrettyStackTraceEntry implements Destructors.ClassWithDestructor {
  public /*const*/PrettyStackTraceEntry /*P*/ NextEntry;
  //<editor-fold defaultstate="collapsed" desc="llvm::PrettyStackTraceEntry::PrettyStackTraceEntry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/PrettyStackTrace.h", line = 33,
   FQN = "llvm::PrettyStackTraceEntry::PrettyStackTraceEntry", NM = "_ZN4llvm21PrettyStackTraceEntryC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm21PrettyStackTraceEntryC1ERKS0_")
  //</editor-fold>
  private PrettyStackTraceEntry(/*const*/PrettyStackTraceEntry /*&*/ $Prm0) {
    throw new UnsupportedOperationException("LLVM_DELETED_FUNCTION");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PrettyStackTraceEntry::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/PrettyStackTrace.h", line = 34,
   FQN = "llvm::PrettyStackTraceEntry::operator=", NM = "_ZN4llvm21PrettyStackTraceEntryaSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm21PrettyStackTraceEntryaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/PrettyStackTraceEntry /*&*/ $Prm0) {
    throw new UnsupportedOperationException("LLVM_DELETED_FUNCTION");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PrettyStackTraceEntry::PrettyStackTraceEntry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 114,
   old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 102,
   FQN = "llvm::PrettyStackTraceEntry::PrettyStackTraceEntry", NM = "_ZN4llvm21PrettyStackTraceEntryC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm21PrettyStackTraceEntryC1Ev")
  //</editor-fold>
  public PrettyStackTraceEntry() {
    // Link ourselves.
    NextEntry = PrettyStackTraceHead.$arrow().get();
    PrettyStackTraceHead.$arrow().set(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PrettyStackTraceEntry::~PrettyStackTraceEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 122,
   old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 108,
   FQN = "llvm::PrettyStackTraceEntry::~PrettyStackTraceEntry", NM = "_ZN4llvm21PrettyStackTraceEntryD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm21PrettyStackTraceEntryD0Ev")
  //</editor-fold>
  public void $destroy() {
    // Do nothing if PrettyStackTraceHead is uninitialized. This can only happen
    // if a shutdown occurred after we created the PrettyStackTraceEntry. That
    // does occur in the following idiom:
    //
    // PrettyStackTraceProgram X(...);
    // llvm_shutdown_obj Y;
    //
    // Without this check, we may end up removing ourselves from the stack trace
    // after PrettyStackTraceHead has already been destroyed.
    if (!PrettyStackTraceHead.isConstructed()) {
      return;
    }
    // JAVA: do not corrupt NativeTrace.firstException by asserts from $destroy
    if (PrettyStackTraceHead.$arrow().get() != this) {
      NativeTrace.printDebuggingStackFrames("PrettyStackTrace ERROR: Pretty stack trace entry destruction is out of order " + 
        "(If in finally then check exception thrown in try/catch) ");
      return;
    }
    assert (PrettyStackTraceHead.$arrow().get() == this) : "Pretty stack trace entry destruction is out of order";
    PrettyStackTraceHead.$arrow().set(getNextEntry());
  }

  
  /// print - Emit information about this stack frame to OS.
  //<editor-fold defaultstate="collapsed" desc="llvm::PrettyStackTraceEntry::print">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/PrettyStackTrace.h", line = 40,
   FQN = "llvm::PrettyStackTraceEntry::print", NM = "_ZNK4llvm21PrettyStackTraceEntry5printERNS_11raw_ostreamE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZNK4llvm21PrettyStackTraceEntry5printERNS_11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void print(raw_ostream /*&*/ OS) /*const*//* = 0*/;

  
  /// getNextEntry - Return the next entry in the list of frames.
  //<editor-fold defaultstate="collapsed" desc="llvm::PrettyStackTraceEntry::getNextEntry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/PrettyStackTrace.h", line = 43,
   FQN = "llvm::PrettyStackTraceEntry::getNextEntry", NM = "_ZNK4llvm21PrettyStackTraceEntry12getNextEntryEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZNK4llvm21PrettyStackTraceEntry12getNextEntryEv")
  //</editor-fold>
  public /*const*/PrettyStackTraceEntry /*P*/ getNextEntry() /*const*/ {
    return NextEntry;
  }

}
