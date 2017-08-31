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

package org.llvm.support.yaml;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import static org.llvm.support.yaml.YamlGlobals.*;

// Base class for Input and Output.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 455,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 456,
 FQN="llvm::yaml::IO", NM="_ZN4llvm4yaml2IOE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IOE")
//</editor-fold>
public abstract class IO implements Destructors.ClassWithDestructor {
/*public:*/
  
  
  //===----------------------------------------------------------------------===//
  //  IO
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::IO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 29,
   FQN="llvm::yaml::IO::IO", NM="_ZN4llvm4yaml2IOC1EPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IOC1EPv")
  //</editor-fold>
  public IO() {
    this((Object/*void P*/ )null);
  }
  public IO(Object/*void P*/ Context/*= null*/) {
    // : Ctxt(Context) 
    //START JInit
    this.Ctxt = Context;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::~IO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 32,
   FQN="llvm::yaml::IO::~IO", NM="_ZN4llvm4yaml2IOD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IOD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::outputting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 461,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 462,
   FQN="llvm::yaml::IO::outputting", NM="_ZN4llvm4yaml2IO10outputtingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO10outputtingEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean outputting()/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::beginSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 463,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 464,
   FQN="llvm::yaml::IO::beginSequence", NM="_ZN4llvm4yaml2IO13beginSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO13beginSequenceEv")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int beginSequence()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::preflightElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 464,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 465,
   FQN="llvm::yaml::IO::preflightElement", NM="_ZN4llvm4yaml2IO16preflightElementEjRPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO16preflightElementEjRPv")
  //</editor-fold>
  public abstract /*virtual*/ boolean preflightElement(/*uint*/int $Prm0, final type$ref<Object>/*void P&*/ $Prm1)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::postflightElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 465,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 466,
   FQN="llvm::yaml::IO::postflightElement", NM="_ZN4llvm4yaml2IO17postflightElementEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO17postflightElementEPv")
  //</editor-fold>
  public abstract /*virtual*/ void postflightElement(Object/*void P*/ $Prm0)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::endSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 466,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 467,
   FQN="llvm::yaml::IO::endSequence", NM="_ZN4llvm4yaml2IO11endSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO11endSequenceEv")
  //</editor-fold>
  public abstract /*virtual*/ void endSequence()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::canElideEmptySequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 467,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 468,
   FQN="llvm::yaml::IO::canElideEmptySequence", NM="_ZN4llvm4yaml2IO21canElideEmptySequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO21canElideEmptySequenceEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean canElideEmptySequence()/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::beginFlowSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 469,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 470,
   FQN="llvm::yaml::IO::beginFlowSequence", NM="_ZN4llvm4yaml2IO17beginFlowSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO17beginFlowSequenceEv")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int beginFlowSequence()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::preflightFlowElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 470,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 471,
   FQN="llvm::yaml::IO::preflightFlowElement", NM="_ZN4llvm4yaml2IO20preflightFlowElementEjRPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO20preflightFlowElementEjRPv")
  //</editor-fold>
  public abstract /*virtual*/ boolean preflightFlowElement(/*uint*/int $Prm0, final type$ref<Object>/*void P&*/ $Prm1)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::postflightFlowElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 471,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 472,
   FQN="llvm::yaml::IO::postflightFlowElement", NM="_ZN4llvm4yaml2IO21postflightFlowElementEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO21postflightFlowElementEPv")
  //</editor-fold>
  public abstract /*virtual*/ void postflightFlowElement(Object/*void P*/ $Prm0)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::endFlowSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 472,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 473,
   FQN="llvm::yaml::IO::endFlowSequence", NM="_ZN4llvm4yaml2IO15endFlowSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO15endFlowSequenceEv")
  //</editor-fold>
  public abstract /*virtual*/ void endFlowSequence()/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 474,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 475,
   FQN="llvm::yaml::IO::mapTag", NM="_ZN4llvm4yaml2IO6mapTagENS_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO6mapTagENS_9StringRefEb")
  //</editor-fold>
  public abstract /*virtual*/ boolean mapTag(StringRef Tag, boolean Default/*= false*/)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::beginMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 475,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 476,
   FQN="llvm::yaml::IO::beginMapping", NM="_ZN4llvm4yaml2IO12beginMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO12beginMappingEv")
  //</editor-fold>
  public abstract /*virtual*/ void beginMapping()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::endMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 476,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 477,
   FQN="llvm::yaml::IO::endMapping", NM="_ZN4llvm4yaml2IO10endMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO10endMappingEv")
  //</editor-fold>
  public abstract /*virtual*/ void endMapping()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::preflightKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 477,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 478,
   FQN="llvm::yaml::IO::preflightKey", NM="_ZN4llvm4yaml2IO12preflightKeyEPKcbbRbRPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO12preflightKeyEPKcbbRbRPv")
  //</editor-fold>
  public abstract /*virtual*/ boolean preflightKey(/*const*/char$ptr/*char P*/ $Prm0, boolean $Prm1, boolean $Prm2, final bool$ref/*bool &*/ $Prm3, final type$ref<Object>/*void P&*/ $Prm4)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::postflightKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 478,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 479,
   FQN="llvm::yaml::IO::postflightKey", NM="_ZN4llvm4yaml2IO13postflightKeyEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO13postflightKeyEPv")
  //</editor-fold>
  public abstract /*virtual*/ void postflightKey(Object/*void P*/ $Prm0)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::beginFlowMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 480,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 481,
   FQN="llvm::yaml::IO::beginFlowMapping", NM="_ZN4llvm4yaml2IO16beginFlowMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO16beginFlowMappingEv")
  //</editor-fold>
  public abstract /*virtual*/ void beginFlowMapping()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::endFlowMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 481,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 482,
   FQN="llvm::yaml::IO::endFlowMapping", NM="_ZN4llvm4yaml2IO14endFlowMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO14endFlowMappingEv")
  //</editor-fold>
  public abstract /*virtual*/ void endFlowMapping()/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::beginEnumScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 483,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 484,
   FQN="llvm::yaml::IO::beginEnumScalar", NM="_ZN4llvm4yaml2IO15beginEnumScalarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO15beginEnumScalarEv")
  //</editor-fold>
  public abstract /*virtual*/ void beginEnumScalar()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::matchEnumScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 484,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 485,
   FQN="llvm::yaml::IO::matchEnumScalar", NM="_ZN4llvm4yaml2IO15matchEnumScalarEPKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO15matchEnumScalarEPKcb")
  //</editor-fold>
  public abstract /*virtual*/ boolean matchEnumScalar(/*const*/char$ptr/*char P*/ $Prm0, boolean $Prm1)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::matchEnumFallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 485,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 486,
   FQN="llvm::yaml::IO::matchEnumFallback", NM="_ZN4llvm4yaml2IO17matchEnumFallbackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO17matchEnumFallbackEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean matchEnumFallback()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::endEnumScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 486,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 487,
   FQN="llvm::yaml::IO::endEnumScalar", NM="_ZN4llvm4yaml2IO13endEnumScalarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO13endEnumScalarEv")
  //</editor-fold>
  public abstract /*virtual*/ void endEnumScalar()/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::beginBitSetScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 488,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 489,
   FQN="llvm::yaml::IO::beginBitSetScalar", NM="_ZN4llvm4yaml2IO17beginBitSetScalarERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO17beginBitSetScalarERb")
  //</editor-fold>
  public abstract /*virtual*/ boolean beginBitSetScalar(final bool$ref/*bool &*/ $Prm0)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::bitSetMatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 489,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 490,
   FQN="llvm::yaml::IO::bitSetMatch", NM="_ZN4llvm4yaml2IO11bitSetMatchEPKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO11bitSetMatchEPKcb")
  //</editor-fold>
  public abstract /*virtual*/ boolean bitSetMatch(/*const*/char$ptr/*char P*/ $Prm0, boolean $Prm1)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::endBitSetScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 490,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 491,
   FQN="llvm::yaml::IO::endBitSetScalar", NM="_ZN4llvm4yaml2IO15endBitSetScalarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO15endBitSetScalarEv")
  //</editor-fold>
  public abstract /*virtual*/ void endBitSetScalar()/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::scalarString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 492,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 493,
   FQN="llvm::yaml::IO::scalarString", NM="_ZN4llvm4yaml2IO12scalarStringERNS_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO12scalarStringERNS_9StringRefEb")
  //</editor-fold>
  public abstract /*virtual*/ void scalarString(final StringRef /*&*/ $Prm0, boolean $Prm1)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::blockScalarString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 493,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 494,
   FQN="llvm::yaml::IO::blockScalarString", NM="_ZN4llvm4yaml2IO17blockScalarStringERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO17blockScalarStringERNS_9StringRefE")
  //</editor-fold>
  public abstract /*virtual*/ void blockScalarString(final StringRef /*&*/ $Prm0)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::setError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 495,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 496,
   FQN="llvm::yaml::IO::setError", NM="_ZN4llvm4yaml2IO8setErrorERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO8setErrorERKNS_5TwineE")
  //</editor-fold>
  public abstract /*virtual*/ void setError(final /*const*/ Twine /*&*/ $Prm0)/* = 0*/;

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::enumCase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 498,
   FQN="llvm::yaml::IO::enumCase", NM="Tpl__ZN4llvm4yaml2IO8enumCaseERT_PKcS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml2IO8enumCaseERT_PKcS2_")
  //</editor-fold>
  public </*typename*/ T extends Enum<?>> void enumCase_T$R_char$ptr$C_T$C(final type$ref<T> /*&*/ Val, /*const*/char$ptr/*char P*/ Str, /*const*/ T ConstVal) {
    if (matchEnumScalar(Str, outputting() && Native.$eq(Val.$deref(), ConstVal))) {
      Val.$set(ConstVal);
    }
  }

  
  // allow anonymous enum values to be used with LLVM_YAML_STRONG_TYPEDEF
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::enumCase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 506,
   FQN="llvm::yaml::IO::enumCase", NM="Tpl__ZN4llvm4yaml2IO8enumCaseERT_PKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml2IO8enumCaseERT_PKcj")
  //</editor-fold>
  public </*typename*/ T> void enumCase_T$R_char$ptr$C_int$C(Class<T> cls, final type$ref<T> /*&*/ Val, /*const*/char$ptr/*char P*/ Str, /*const*//*uint32_t*/int ConstVal) {
    T t;
    try {
      Method method = cls.getMethod("valueOf", Integer.class);
      t = (T) method.invoke(cls, ConstVal);
      if (matchEnumScalar(Str, outputting() && Native.$eq(Val, t))) {
        Val.$set(t);
      }
    } catch (NoSuchMethodException ex) {
      Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
      Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
      Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvocationTargetException ex) {
      Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  
  /*template <typename FBT, typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::enumFallback">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 514,
   FQN="llvm::yaml::IO::enumFallback", NM="_ZN4llvm4yaml2IO12enumFallbackERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO12enumFallbackERT0_")
  //</editor-fold>
  public </*typename*/ FBT, /*typename*/ T> void enumFallback(T /*&*/ Val) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::bitSetCase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 524,
   FQN="llvm::yaml::IO::bitSetCase", NM="_ZN4llvm4yaml2IO10bitSetCaseERT_PKcS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO10bitSetCaseERT_PKcS2_")
  //</editor-fold>
  public </*typename*/ T> void bitSetCase(T /*&*/ Val, /*const*/char$ptr/*char P*/ Str, /*const*/ T ConstVal) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // allow anonymous enum values to be used with LLVM_YAML_STRONG_TYPEDEF
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::bitSetCase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 532,
   FQN="llvm::yaml::IO::bitSetCase", NM="_ZN4llvm4yaml2IO10bitSetCaseERT_PKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO10bitSetCaseERT_PKcj")
  //</editor-fold>
  public </*typename*/ T> void bitSetCase(T /*&*/ Val, /*const*/char$ptr/*char P*/ Str, /*const*//*uint32_t*/int ConstVal) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::maskedBitSetCase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 539,
   FQN="llvm::yaml::IO::maskedBitSetCase", NM="_ZN4llvm4yaml2IO16maskedBitSetCaseERT_PKcS2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO16maskedBitSetCaseERT_PKcS2_S2_")
  //</editor-fold>
  public </*typename*/ T> void maskedBitSetCase(T /*&*/ Val, /*const*/char$ptr/*char P*/ Str, T ConstVal, T Mask) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::maskedBitSetCase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 545,
   FQN="llvm::yaml::IO::maskedBitSetCase", NM="_ZN4llvm4yaml2IO16maskedBitSetCaseERT_PKcjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO16maskedBitSetCaseERT_PKcjj")
  //</editor-fold>
  public </*typename*/ T> void maskedBitSetCase(T /*&*/ Val, /*const*/char$ptr/*char P*/ Str, /*uint32_t*/int ConstVal, 
                                      /*uint32_t*/int Mask) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 35,
   FQN="llvm::yaml::IO::getContext", NM="_ZN4llvm4yaml2IO10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO10getContextEv")
  //</editor-fold>
  public Object/*void P*/ getContext() {
    return Ctxt;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::setContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 39,
   FQN="llvm::yaml::IO::setContext", NM="_ZN4llvm4yaml2IO10setContextEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO10setContextEPv")
  //</editor-fold>
  public void setContext(Object/*void P*/ Context) {
    Ctxt = Context;
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapRequired">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 554,
   FQN="llvm::yaml::IO::mapRequired", NM="Tpl__ZN4llvm4yaml2IO11mapRequiredEPKcRT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml2IO11mapRequiredEPKcRT_")
  //</editor-fold>
  public </*typename*/ T> void mapRequired(/*const*/char$ptr/*char P*/ Key, ScalarEnumerationTraits<T> traits, type$ref<T> /*&*/ Val) {
    this.processKey(Key, traits, Val, true);
  }

  
  //template <typename T = basic_string<char>> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapOptional">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 573,
   FQN="llvm::yaml::IO::mapOptional", NM="_ZN4llvm4yaml2IO11mapOptionalISsEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS4_R_ZTSv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO11mapOptionalISsEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS4_R_ZTSv")
  //</editor-fold>
  public <X, /*typename*/ T extends Sequence<type$ref<X>>> void mapOptional$YamlConvertible(/*const*/char$ptr/*char P*/ Key, SequenceTraits<X,T> traits, final T/*&*/ Val) {
    this.processKey(Key, traits, Val, false);
  }
//  /*template <typename T> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapOptional">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 560,
//   FQN="llvm::yaml::IO::mapOptional", NM="_ZN4llvm4yaml2IO11mapOptionalEPKcRT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueEvE4typeE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO11mapOptionalEPKcRT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueEvE4typeE")
//  //</editor-fold>
//  public </*typename*/ T> /*std::enable_if<has_SequenceTraits<T>::value, void>::type*/void mapOptional$YamlConvertible(/*const*/char$ptr/*char P*/ Key, T /*&*/ Val) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapOptional">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 568,
   FQN="llvm::yaml::IO::mapOptional", NM="Tpl__ZN4llvm4yaml2IO11mapOptionalEPKcRNS_8OptionalIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml2IO11mapOptionalEPKcRNS_8OptionalIT_EE")
  //</editor-fold>
  public </*typename*/ T> void mapOptional(/*const*/char$ptr/*char P*/ Key, final Optional<T> /*&*/ Val) {
    processKeyWithDefault(Key, Val, new Optional<T>(), /*Required=*/ false);
  }

  
  //template <typename T = LanguageKind> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapOptional">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 573,
   FQN="llvm::yaml::IO::mapOptional", NM="_ZN4llvm4yaml2IO11mapOptionalIN5clang6format11FormatStyle12LanguageKindEEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS8_R_ZTSv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO11mapOptionalIN5clang6format11FormatStyle12LanguageKindEEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS8_R_ZTSv")
  //</editor-fold>
  public </*typename*/ T> void mapOptional$NotYamlConvertible(/*const*/char$ptr/*char P*/ Key,  ScalarEnumerationTraits<T> traits, final type$ref<T /*&*/> Val) {
    this.processKey(Key, traits, Val, false);
  }
  //template <typename T = StringRef> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapOptional">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 573,
   FQN="llvm::yaml::IO::mapOptional", NM="_ZN4llvm4yaml2IO11mapOptionalINS_9StringRefEEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS5_R_ZTSv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO11mapOptionalINS_9StringRefEEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS5_R_ZTSv")
  //</editor-fold>
  public void mapOptional$NotYamlConvertible(/*const*/char$ptr/*char P*/ Key, ScalarTraitsStringRef traits, final StringRef /*&*/ Val) {
    this.processKey(Key, traits, Val, false);
  }
  //template <typename T = bool> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapOptional">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 573,
   FQN="llvm::yaml::IO::mapOptional", NM="_ZN4llvm4yaml2IO11mapOptionalIbEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS4_R_ZTSv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO11mapOptionalIbEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS4_R_ZTSv")
  //</editor-fold>
  public void mapOptional$NotYamlConvertible(/*const*/char$ptr/*char P*/ Key, ScalarTraitsBool traits, final bool$ref/*bool &*/ Val) {
    this.processKey(Key, traits, Val, false);
  }
  //template <typename T = int> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapOptional">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 573,
   FQN="llvm::yaml::IO::mapOptional", NM="_ZN4llvm4yaml2IO11mapOptionalIiEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS4_R_ZTSv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO11mapOptionalIiEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS4_R_ZTSv")
  //</editor-fold>
  public void mapOptional$NotYamlConvertible(/*const*/char$ptr/*char P*/ Key, ScalarTraitsInt traits, final int$ref/*int &*/ Val) {
    this.processKey(Key, traits, Val, false);
  }
  //template <typename T = BraceWrappingFlags> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapOptional">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 573,
   FQN="llvm::yaml::IO::mapOptional", NM="_ZN4llvm4yaml2IO11mapOptionalIN5clang6format11FormatStyle18BraceWrappingFlagsEEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS8_R_ZTSv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO11mapOptionalIN5clang6format11FormatStyle18BraceWrappingFlagsEEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS8_R_ZTSv")
  //</editor-fold>
  public </*typename*/ T> void mapOptional$NotYamlConvertible(/*const*/char$ptr/*char P*/ Key, MappingTraits<T> traits, final T /*&*/ Val) {
    this.processKey(Key, traits, Val, false);
  }
  //template <typename T = unsigned int> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapOptional">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 573,
   FQN="llvm::yaml::IO::mapOptional", NM="_ZN4llvm4yaml2IO11mapOptionalIjEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS4_R_ZTSv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO11mapOptionalIjEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS4_R_ZTSv")
  //</editor-fold>
  public void mapOptional$NotYamlConvertible(/*const*/char$ptr/*char P*/ Key, ScalarTraitsUInt traits, final uint$ref/*uint &*/ Val) {
    this.processKey(Key, traits, Val, false);
  }
  //template <typename T = basic_string<char>> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapOptional">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 573,
   FQN="llvm::yaml::IO::mapOptional", NM="_ZN4llvm4yaml2IO11mapOptionalISsEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS4_R_ZTSv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO11mapOptionalISsEENSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeEPKcRS4_R_ZTSv")
  //</editor-fold>
  public void mapOptional$NotYamlConvertible(/*const*/char$ptr/*char P*/ Key, ScalarTraitsString traits, final std.string/*&*/ Val) {
    this.processKey(Key, traits, Val, false);
  }
//  /*template <typename T> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapOptional">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 573,
//   FQN="llvm::yaml::IO::mapOptional", NM="Tpl__ZN4llvm4yaml2IO11mapOptionalEPKcRT_R_ZTSNSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=Tpl__ZN4llvm4yaml2IO11mapOptionalEPKcRT_R_ZTSNSt9enable_ifIXntsr18has_SequenceTraitsIT_EE5valueEvE4typeE")
//  //</editor-fold>
//  public </*typename*/ T> /*std::enable_if<!has_SequenceTraits<T>::value, void>::type*/void mapOptional$NotYamlConvertible(/*const*/char$ptr/*char P*/ Key, final T /*&*/ Val) {
//    this.processKey(Key, Val, false);
//  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::mapOptional">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 579,
   FQN="llvm::yaml::IO::mapOptional", NM="Tpl__ZN4llvm4yaml2IO11mapOptionalEPKcRT_RKS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml2IO11mapOptionalEPKcRT_RKS4_")
  //</editor-fold>
  public </*typename*/ T> void mapOptional(/*const*/char$ptr/*char P*/ Key, final T /*&*/ Val, final /*const*/ T /*&*/ Default) {
    this.processKeyWithDefault(Key, Val, Default, false);
  }

/*private:*/
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::processKeyWithDefault">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 586,
   FQN="llvm::yaml::IO::processKeyWithDefault", NM="_ZN4llvm4yaml2IO21processKeyWithDefaultEPKcRNS_8OptionalIT_EERKS6_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO21processKeyWithDefaultEPKcRNS_8OptionalIT_EERKS6_b")
  //</editor-fold>
  private </*typename*/ T> void processKeyWithDefault(/*const*/char$ptr/*char P*/ Key, Optional<T> /*&*/ Val, 
                       /*const*/ Optional<T> /*&*/ DefaultValue, boolean Required) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::processKeyWithDefault">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 606,
   FQN="llvm::yaml::IO::processKeyWithDefault", NM="_ZN4llvm4yaml2IO21processKeyWithDefaultEPKcRT_RKS4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml2IO21processKeyWithDefaultEPKcRT_RKS4_b")
  //</editor-fold>
  private </*typename*/ T> void processKeyWithDefault(/*const*/char$ptr/*char P*/ Key, T /*&*/ Val, /*const*/ T /*&*/ DefaultValue, 
                       boolean Required) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //template <typename T = LanguageKind> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::processKey">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 622,
   FQN="llvm::yaml::IO::processKey", NM="_ZN4llvm4yaml2IO10processKeyIN5clang6format11FormatStyle12LanguageKindEEEvPKcRT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO10processKeyIN5clang6format11FormatStyle12LanguageKindEEEvPKcRT_b")
  //</editor-fold>
  private </*typename*/ T> void processKey(/*const*/char$ptr/*char P*/ Key, ScalarEnumerationTraits<T> traits, final type$ref<T /*&*/> Val, boolean Required) {
    type$ref<Object/*void P*/ > SaveInfo = create_type$ref();
    bool$ref UseDefault = create_bool$ref();
    if (this.preflightKey(Key, Required, false, UseDefault, SaveInfo)) {
      yamlize$HasScalarEnumerationTraits(/*Deref*/this, traits, Val, Required);
      this.postflightKey(SaveInfo.$deref());
    }
  }
  //template <typename T = StringRef> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::processKey">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 622,
   FQN="llvm::yaml::IO::processKey", NM="_ZN4llvm4yaml2IO10processKeyINS_9StringRefEEEvPKcRT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO10processKeyINS_9StringRefEEEvPKcRT_b")
  //</editor-fold>
  private void processKey(/*const*/char$ptr/*char P*/ Key, ScalarTraitsStringRef traits, final StringRef /*&*/ Val, boolean Required) {
    type$ref<Object/*void P*/ > SaveInfo = create_type$ref();
    bool$ref UseDefault = create_bool$ref();
    if (this.preflightKey(Key, Required, false, UseDefault, SaveInfo)) {
      yamlize$HasScalarTraits(/*Deref*/this, traits, Val, Required);
      this.postflightKey(SaveInfo.$deref());
    }
  }
  //template <typename T = bool> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::processKey">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 622,
   FQN="llvm::yaml::IO::processKey", NM="_ZN4llvm4yaml2IO10processKeyIbEEvPKcRT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO10processKeyIbEEvPKcRT_b")
  //</editor-fold>
  private void processKey(/*const*/char$ptr/*char P*/ Key, ScalarTraitsBool traits, final bool$ref/*bool &*/ Val, boolean Required) {
    type$ref<Object/*void P*/ > SaveInfo = create_type$ref();
    bool$ref UseDefault = create_bool$ref();
    if (this.preflightKey(Key, Required, false, UseDefault, SaveInfo)) {
      yamlize$HasScalarTraits(/*Deref*/this, traits, Val, Required);
      this.postflightKey(SaveInfo.$deref());
    }
  }
  //template <typename T = int> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::processKey">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 622,
   FQN="llvm::yaml::IO::processKey", NM="_ZN4llvm4yaml2IO10processKeyIiEEvPKcRT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO10processKeyIiEEvPKcRT_b")
  //</editor-fold>
  private void processKey(/*const*/char$ptr/*char P*/ Key, ScalarTraitsInt traits, final int$ref/*int &*/ Val, boolean Required) {
    type$ref<Object/*void P*/ > SaveInfo = create_type$ref();
    bool$ref UseDefault = create_bool$ref();
    if (this.preflightKey(Key, Required, false, UseDefault, SaveInfo)) {
      yamlize$HasScalarTraits(/*Deref*/this, traits, Val, Required);
      this.postflightKey(SaveInfo.$deref());
    }
  }
  //template <typename T = BraceWrappingFlags> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::processKey">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 622,
   FQN="llvm::yaml::IO::processKey", NM="_ZN4llvm4yaml2IO10processKeyIN5clang6format11FormatStyle18BraceWrappingFlagsEEEvPKcRT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO10processKeyIN5clang6format11FormatStyle18BraceWrappingFlagsEEEvPKcRT_b")
  //</editor-fold>
  private </*typename*/ T> void processKey(/*const*/char$ptr/*char P*/ Key, MappingTraits<T> traits, final T /*&*/ Val, boolean Required) {
    type$ref<Object/*void P*/ > SaveInfo = create_type$ref();
    bool$ref UseDefault = create_bool$ref();
    if (this.preflightKey(Key, Required, false, UseDefault, SaveInfo)) {
      yamlize$NotValidatedMappingTraits(/*Deref*/this, traits, Val, Required);
      this.postflightKey(SaveInfo.$deref());
    }
  }
  //template <typename T = unsigned int> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::processKey">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 622,
   FQN="llvm::yaml::IO::processKey", NM="_ZN4llvm4yaml2IO10processKeyIjEEvPKcRT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO10processKeyIjEEvPKcRT_b")
  //</editor-fold>
  private void processKey(/*const*/char$ptr/*char P*/ Key, ScalarTraitsUInt traits, final uint$ref/*uint &*/ Val, boolean Required) {
    type$ref<Object/*void P*/ > SaveInfo = create_type$ref();
    bool$ref UseDefault = create_bool$ref();
    if (this.preflightKey(Key, Required, false, UseDefault, SaveInfo)) {
      yamlize$HasScalarTraits(/*Deref*/this, traits, Val, Required);
      this.postflightKey(SaveInfo.$deref());
    }
  }
  //template <typename T = basic_string<char>> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::processKey">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 622,
   FQN="llvm::yaml::IO::processKey", NM="_ZN4llvm4yaml2IO10processKeyISsEEvPKcRT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO10processKeyISsEEvPKcRT_b")
  //</editor-fold>
  private void processKey(/*const*/char$ptr/*char P*/ Key, ScalarTraitsString traits, final std.string/*&*/ Val, boolean Required) {
    type$ref<Object/*void P*/ > SaveInfo = create_type$ref();
    bool$ref UseDefault = create_bool$ref();
    if (this.preflightKey(Key, Required, false, UseDefault, SaveInfo)) {
      yamlize$HasScalarTraits(/*Deref*/this, traits, Val, Required);
      this.postflightKey(SaveInfo.$deref());
    }
  }
  //template <typename T = vector<basic_string<char>, allocator<basic_string<char> > >> 
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::processKey">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 622,
   FQN="llvm::yaml::IO::processKey", NM="_ZN4llvm4yaml2IO10processKeyISt6vectorISsSaISsEEEEvPKcRT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml2IO10processKeyISt6vectorISsSaISsEEEEvPKcRT_b")
  //</editor-fold>
  private <X, /*typename*/ T extends Sequence<type$ref<X>>> void processKey(/*const*/char$ptr/*char P*/ Key, SequenceTraits<X,T> traits, final T /*&*/ Val, boolean Required) {
    
    type$ref<Object/*void P*/ > SaveInfo = create_type$ref();
    bool$ref UseDefault = create_bool$ref();
    if (this.preflightKey(Key, Required, false, UseDefault, SaveInfo)) {
      yamlize$YamlConvertible(/*Deref*/this, traits, Val, Required);
      this.postflightKey(SaveInfo.$deref());
    }
  }
//  /*template <typename T> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::IO::processKey">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 622,
//   FQN="llvm::yaml::IO::processKey", NM="Tpl__ZN4llvm4yaml2IO10processKeyEPKcRT_b",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=Tpl__ZN4llvm4yaml2IO10processKeyEPKcRT_b")
//  //</editor-fold>
//  private </*typename*/ T> void processKey(/*const*/char$ptr/*char P*/ Key, final T /*&*/ Val, boolean Required) {
//    type$ref<Object/*void P*/ > SaveInfo = create_type$ref();
//    bool$ref UseDefault = create_bool$ref();
//    if (this.preflightKey(Key, Required, false, UseDefault, SaveInfo)) {
//      yamlize(/*Deref*/this, Val, Required);
//      this.postflightKey(SaveInfo.$deref());
//    }
//  }

/*private:*/
  private Object/*void P*/ Ctxt;
  
  @Override public String toString() {
    return "" + "Ctxt=" + NativeTrace.getIdentityStr(Ctxt); // NOI18N
  }
}
