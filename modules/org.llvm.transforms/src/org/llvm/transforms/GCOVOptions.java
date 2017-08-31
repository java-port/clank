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

package org.llvm.transforms;

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
import org.llvm.ir.*;
import org.llvm.ir.legacy.*;
import org.llvm.transforms.*;
import org.llvm.transforms.java.TransformFunctionPointers.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.*;
import org.llvm.support.yaml.*;


// Insert GCOV profiling instrumentation
//<editor-fold defaultstate="collapsed" desc="llvm::GCOVOptions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Instrumentation.h", line = 51,
 FQN="llvm::GCOVOptions", NM="_ZN4llvm11GCOVOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp -nm=_ZN4llvm11GCOVOptionsE")
//</editor-fold>
public class/*struct*/ GCOVOptions {
  //<editor-fold defaultstate="collapsed" desc="llvm::GCOVOptions::getDefault">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp", line = 54,
   FQN="llvm::GCOVOptions::getDefault", NM="_ZN4llvm11GCOVOptions10getDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp -nm=_ZN4llvm11GCOVOptions10getDefaultEv")
  //</editor-fold>
  public static GCOVOptions getDefault() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Specify whether to emit .gcno files.
  public boolean EmitNotes;
  
  // Specify whether to modify the program to emit .gcda files when run.
  public boolean EmitData;
  
  // A four-byte version string. The meaning of a version string is described in
  // gcc's gcov-io.h
  public /*char*/byte Version[/*4*/] = new$char(4);
  
  // Emit a "cfg checksum" that follows the "line number checksum" of a
  // function. This affects both .gcno and .gcda files.
  public boolean UseCfgChecksum;
  
  // Add the 'noredzone' attribute to added runtime library calls.
  public boolean NoRedZone;
  
  // Emit the name of the function in the .gcda files. This is redundant, as
  // the function identifier can be used to find the name from the .gcno file.
  public boolean FunctionNamesInData;
  
  // Emit the exit block immediately after the start block, rather than after
  // all of the function body's blocks.
  public boolean ExitBlockBeforeBody;
  //<editor-fold defaultstate="collapsed" desc="llvm::GCOVOptions::GCOVOptions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Instrumentation.h", line = 51,
   FQN="llvm::GCOVOptions::GCOVOptions", NM="_ZN4llvm11GCOVOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp -nm=_ZN4llvm11GCOVOptionsC1Ev")
  //</editor-fold>
  public /*inline*/ GCOVOptions() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GCOVOptions::GCOVOptions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Instrumentation.h", line = 51,
   FQN="llvm::GCOVOptions::GCOVOptions", NM="_ZN4llvm11GCOVOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp -nm=_ZN4llvm11GCOVOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ GCOVOptions(final /*const*/ GCOVOptions /*&*/ $Prm0) {
    // : EmitNotes(.EmitNotes), EmitData(.EmitData), Version(.Version[__i0]), UseCfgChecksum(.UseCfgChecksum), NoRedZone(.NoRedZone), FunctionNamesInData(.FunctionNamesInData), ExitBlockBeforeBody(.ExitBlockBeforeBody) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GCOVOptions::GCOVOptions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Instrumentation.h", line = 51,
   FQN="llvm::GCOVOptions::GCOVOptions", NM="_ZN4llvm11GCOVOptionsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp -nm=_ZN4llvm11GCOVOptionsC1EOS0_")
  //</editor-fold>
  public /*inline*/ GCOVOptions(JD$Move _dparam, final GCOVOptions /*&&*/$Prm0) {
    // : EmitNotes(static_cast<GCOVOptions &&>().EmitNotes), EmitData(static_cast<GCOVOptions &&>().EmitData), Version(static_cast<char &&>(static_cast<GCOVOptions &&>().Version[__i0])), UseCfgChecksum(static_cast<GCOVOptions &&>().UseCfgChecksum), NoRedZone(static_cast<GCOVOptions &&>().NoRedZone), FunctionNamesInData(static_cast<GCOVOptions &&>().FunctionNamesInData), ExitBlockBeforeBody(static_cast<GCOVOptions &&>().ExitBlockBeforeBody) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "EmitNotes=" + EmitNotes // NOI18N
              + ", EmitData=" + EmitData // NOI18N
              + ", Version=" + Version // NOI18N
              + ", UseCfgChecksum=" + UseCfgChecksum // NOI18N
              + ", NoRedZone=" + NoRedZone // NOI18N
              + ", FunctionNamesInData=" + FunctionNamesInData // NOI18N
              + ", ExitBlockBeforeBody=" + ExitBlockBeforeBody; // NOI18N
  }
}
