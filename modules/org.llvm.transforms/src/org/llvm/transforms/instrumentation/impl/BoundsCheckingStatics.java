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
package org.llvm.transforms.instrumentation.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.Statistic;
import org.llvm.cl.aliases.optBool;
import org.llvm.cl.desc;
import org.llvm.cl.opt;
import org.llvm.pass.*;


//<editor-fold defaultstate="collapsed" desc="static type BoundsCheckingStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.transforms.instrumentation.impl.BoundsCheckingStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZL11ChecksAdded;_ZL12ChecksUnable;_ZL12SingleTrapBB;_ZL13ChecksSkipped;_ZL32InitializeBoundsCheckingPassFlag;_ZL32initializeBoundsCheckingPassOnceRN4llvm12PassRegistryE; -static-type=BoundsCheckingStatics -package=org.llvm.transforms.instrumentation.impl")
//</editor-fold>
public final class BoundsCheckingStatics {

//<editor-fold defaultstate="collapsed" desc="SingleTrapBB">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp", line = 32,
 FQN="SingleTrapBB", NM="_ZL12SingleTrapBB",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZL12SingleTrapBB")
//</editor-fold>
public static optBool SingleTrapBB/*J*/= new optBool(opt.StorageKind.Internal, $("bounds-checking-single-trap"), 
    new desc($("Use one trap block per function")));
//<editor-fold defaultstate="collapsed" desc="ChecksAdded">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp", line = 35,
 FQN="ChecksAdded", NM="_ZL11ChecksAdded",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZL11ChecksAdded")
//</editor-fold>
public static Statistic ChecksAdded = new Statistic($("bounds-checking"), $("ChecksAdded"), $("Bounds checks added"), 0, false);
//<editor-fold defaultstate="collapsed" desc="ChecksSkipped">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp", line = 36,
 FQN="ChecksSkipped", NM="_ZL13ChecksSkipped",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZL13ChecksSkipped")
//</editor-fold>
public static Statistic ChecksSkipped = new Statistic($("bounds-checking"), $("ChecksSkipped"), $("Bounds checks skipped"), 0, false);
//<editor-fold defaultstate="collapsed" desc="ChecksUnable">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp", line = 37,
 FQN="ChecksUnable", NM="_ZL12ChecksUnable",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZL12ChecksUnable")
//</editor-fold>
public static Statistic ChecksUnable = new Statistic($("bounds-checking"), $("ChecksUnable"), $("Bounds checks unable to add"), 0, false);
//<editor-fold defaultstate="collapsed" desc="initializeBoundsCheckingPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp", line = 69,
 FQN="initializeBoundsCheckingPassOnce", NM="_ZL32initializeBoundsCheckingPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZL32initializeBoundsCheckingPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeBoundsCheckingPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeBoundsCheckingPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp", line = 69,
 FQN="InitializeBoundsCheckingPassFlag", NM="_ZL32InitializeBoundsCheckingPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZL32InitializeBoundsCheckingPassFlag")
//</editor-fold>
public static std.once_flag InitializeBoundsCheckingPassFlag/*J*/= new std.once_flag();
} // END OF class BoundsCheckingStatics
