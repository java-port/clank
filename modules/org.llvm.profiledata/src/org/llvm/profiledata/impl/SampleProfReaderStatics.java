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
package org.llvm.profiledata.impl;

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


//<editor-fold defaultstate="collapsed" desc="static type SampleProfReaderStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/SampleProfReader.cpp -nm=_ZL13isOffsetLegalj;_ZL17setupMemoryBufferRKN4llvm5TwineE;_ZL9ParseHeadRKN4llvm9StringRefERS0_RyS4_;_ZL9ParseLineRKN4llvm9StringRefERbRjRyS4_S4_RS0_RNS_8DenseMapIS0_yNS_12DenseMapInfoIS0_EENS_6detail12DenseMapPairIS0_yEEEE; -static-type=SampleProfReaderStatics -package=org.llvm.profiledata.impl")
//</editor-fold>
public final class SampleProfReaderStatics {


/// \brief Parse \p Input as function head.
///
/// Parse one line of \p Input, and update function name in \p FName,
/// function's total sample count in \p NumSamples, function's entry
/// count in \p NumHeadSamples.
///
/// \returns true if parsing is successful.
//<editor-fold defaultstate="collapsed" desc="ParseHead">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/SampleProfReader.cpp", line = 57,
 FQN="ParseHead", NM="_ZL9ParseHeadRKN4llvm9StringRefERS0_RyS4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/SampleProfReader.cpp -nm=_ZL9ParseHeadRKN4llvm9StringRefERS0_RyS4_")
//</editor-fold>
public static boolean ParseHead(final /*const*/ StringRef /*&*/ Input, final StringRef /*&*/ FName, 
         final ulong$ref/*uint64_t &*/ NumSamples, final ulong$ref/*uint64_t &*/ NumHeadSamples) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns true if line offset \p L is legal (only has 16 bits).
//<editor-fold defaultstate="collapsed" desc="isOffsetLegal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/SampleProfReader.cpp", line = 72,
 FQN="isOffsetLegal", NM="_ZL13isOffsetLegalj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/SampleProfReader.cpp -nm=_ZL13isOffsetLegalj")
//</editor-fold>
public static boolean isOffsetLegal(/*uint*/int L) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Parse \p Input as line sample.
///
/// \param Input input line.
/// \param IsCallsite true if the line represents an inlined callsite.
/// \param Depth the depth of the inline stack.
/// \param NumSamples total samples of the line/inlined callsite.
/// \param LineOffset line offset to the start of the function.
/// \param Discriminator discriminator of the line.
/// \param TargetCountMap map from indirect call target to count.
///
/// returns true if parsing is successful.
//<editor-fold defaultstate="collapsed" desc="ParseLine">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/SampleProfReader.cpp", line = 85,
 FQN="ParseLine", NM="_ZL9ParseLineRKN4llvm9StringRefERbRjRyS4_S4_RS0_RNS_8DenseMapIS0_yNS_12DenseMapInfoIS0_EENS_6detail12DenseMapPairIS0_yEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/SampleProfReader.cpp -nm=_ZL9ParseLineRKN4llvm9StringRefERbRjRyS4_S4_RS0_RNS_8DenseMapIS0_yNS_12DenseMapInfoIS0_EENS_6detail12DenseMapPairIS0_yEEEE")
//</editor-fold>
public static boolean ParseLine(final /*const*/ StringRef /*&*/ Input, final bool$ref/*bool &*/ IsCallsite, final /*uint32_t &*/uint$ref Depth, 
         final ulong$ref/*uint64_t &*/ NumSamples, final /*uint32_t &*/uint$ref LineOffset, 
         final /*uint32_t &*/uint$ref Discriminator, final StringRef /*&*/ CalleeName, 
         final DenseMapTypeULong<StringRef> /*&*/ TargetCountMap) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Prepare a memory buffer for the contents of \p Filename.
///
/// \returns an error code indicating the status of the buffer.
//<editor-fold defaultstate="collapsed" desc="setupMemoryBuffer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/SampleProfReader.cpp", line = 735,
 FQN="setupMemoryBuffer", NM="_ZL17setupMemoryBufferRKN4llvm5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/SampleProfReader.cpp -nm=_ZL17setupMemoryBufferRKN4llvm5TwineE")
//</editor-fold>
public static ErrorOr<std.unique_ptr<MemoryBuffer> > setupMemoryBuffer(final /*const*/ Twine /*&*/ Filename) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class SampleProfReaderStatics
