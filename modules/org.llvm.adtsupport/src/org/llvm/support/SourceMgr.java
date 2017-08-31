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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.support.impl.*;
import static org.llvm.support.impl.SourceMgrStatics.getCache;
import org.llvm.support.sys.*;


/// This owns the files read by a parser, handles include stacks,
/// and handles diagnostic wrangling.
//<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 35,
 FQN="llvm::SourceMgr", NM="_ZN4llvm9SourceMgrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgrE")
//</editor-fold>
public class SourceMgr implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::DiagKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 37,
   FQN="llvm::SourceMgr::DiagKind", NM="_ZN4llvm9SourceMgr8DiagKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgr8DiagKindE")
  //</editor-fold>
  public enum DiagKind implements Native.NativeUIntEnum {
    DK_Error(0),
    DK_Warning(DK_Error.getValue() + 1),
    DK_Note(DK_Warning.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DiagKind valueOf(int val) {
      DiagKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DiagKind[] VALUES;
      private static final DiagKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DiagKind kind : DiagKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DiagKind[min < 0 ? (1-min) : 0];
        VALUES = new DiagKind[max >= 0 ? (1+max) : 0];
        for (DiagKind kind : DiagKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private DiagKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// Clients that want to handle their own diagnostics in a custom way can
  /// register a function pointer+context as a diagnostic handler.
  /// It gets called each time PrintMessage is invoked.
  // JAVA: typedef void (*DiagHandlerTy)(const SMDiagnostic &, void *);
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::SrcBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 48,
   FQN="llvm::SourceMgr::SrcBuffer", NM="_ZN4llvm9SourceMgr9SrcBufferE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgr9SrcBufferE")
  //</editor-fold>
  private static class/*struct*/ SrcBuffer implements Destructors.ClassWithDestructor, Native.NativePOD<SrcBuffer> {
    /// The memory buffer for the file.
    public std.unique_ptr<MemoryBuffer> Buffer;
    
    /// This is the location of the parent include, or null if at the top level.
    public SMLoc IncludeLoc;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::SrcBuffer::SrcBuffer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 55,
     FQN="llvm::SourceMgr::SrcBuffer::SrcBuffer", NM="_ZN4llvm9SourceMgr9SrcBufferC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgr9SrcBufferC1Ev")
    //</editor-fold>
    public SrcBuffer() {
      // : Buffer(), IncludeLoc() 
      //START JInit
      this.Buffer = new std.unique_ptr<MemoryBuffer>();
      this.IncludeLoc = new SMLoc();
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::SrcBuffer::SrcBuffer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 57,
     FQN="llvm::SourceMgr::SrcBuffer::SrcBuffer", NM="_ZN4llvm9SourceMgr9SrcBufferC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgr9SrcBufferC1EOS1_")
    //</editor-fold>
    public SrcBuffer(JD$Move _dparam, final SrcBuffer /*&&*/O) {
      // : Buffer(std::move(O.Buffer)), IncludeLoc(O.IncludeLoc) 
      //START JInit
      this.Buffer = new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(O.Buffer));
      this.IncludeLoc = new SMLoc(O.IncludeLoc);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::SrcBuffer::~SrcBuffer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 48,
     FQN="llvm::SourceMgr::SrcBuffer::~SrcBuffer", NM="_ZN4llvm9SourceMgr9SrcBufferD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgr9SrcBufferD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Buffer.$destroy();
      //END JDestroy
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override
    public SrcBuffer $assign(SrcBuffer value) {
      this.Buffer = new unique_ptr<>(value.Buffer);
      this.IncludeLoc = new SMLoc(value.IncludeLoc);
      return this;
    }

    @Override
    public SrcBuffer clone() {
      SrcBuffer res = new SrcBuffer();
      res.$assign(this);
      return res;
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "Buffer=" + Buffer // NOI18N
                + ", IncludeLoc=" + IncludeLoc; // NOI18N
    }
  };
  
  /// This is all of the buffers that we are reading from.
  private std.vector<SrcBuffer> Buffers;
  
  // This is the list of directories we should search for include files in.
  private std.vectorString IncludeDirectories;
  
  /// This is a cache for line number queries, its implementation is really
  /// private to SourceMgr.cpp.
  private /*mutable */Object/*void P*/ LineNoCache;
  
  private DiagHandlerTy DiagHandler;
  private Object/*void P*/ DiagContext;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::isValidBufferID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 74,
   FQN="llvm::SourceMgr::isValidBufferID", NM="_ZNK4llvm9SourceMgr15isValidBufferIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr15isValidBufferIDEj")
  //</editor-fold>
  private boolean isValidBufferID(/*uint*/int i) /*const*/ {
    return (i != 0) && $lesseq_uint(i, Buffers.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::SourceMgr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 76,
   FQN="llvm::SourceMgr::SourceMgr", NM="_ZN4llvm9SourceMgrC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgrC1ERKS0_")
  //</editor-fold>
  protected/*private*/ SourceMgr(final /*const*/ SourceMgr /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 77,
   FQN="llvm::SourceMgr::operator=", NM="_ZN4llvm9SourceMgraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgraSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ SourceMgr /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::SourceMgr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 79,
   FQN="llvm::SourceMgr::SourceMgr", NM="_ZN4llvm9SourceMgrC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgrC1Ev")
  //</editor-fold>
  public SourceMgr() {
    // : Buffers(), IncludeDirectories(), LineNoCache(null), DiagHandler(null), DiagContext(null) 
    //START JInit
    this.Buffers = new std.vector<SrcBuffer>(new SrcBuffer());
    this.IncludeDirectories = new std.vectorString(std.string.EMPTY);
    this.LineNoCache = null;
    this.DiagHandler = null;
    this.DiagContext = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::~SourceMgr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 39,
   FQN="llvm::SourceMgr::~SourceMgr", NM="_ZN4llvm9SourceMgrD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgrD0Ev")
  //</editor-fold>
  public void $destroy() {
    {
      // Delete the line # cache if allocated.
      LineNoCacheTy /*P*/ Cache = getCache(LineNoCache);
      if ((Cache != null)) {
        /*delete*/Destructors.$destroy(Cache);
      }
    }
    //START JDestroy
    IncludeDirectories.$destroy();
    Buffers.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::setIncludeDirs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 83,
   FQN="llvm::SourceMgr::setIncludeDirs", NM="_ZN4llvm9SourceMgr14setIncludeDirsERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgr14setIncludeDirsERKSt6vectorISsSaISsEE")
  //</editor-fold>
  public void setIncludeDirs(final /*const*/std.vectorString/*&*/ Dirs) {
    IncludeDirectories.$assign(Dirs);
  }

  
  /// Specify a diagnostic handler to be invoked every time PrintMessage is
  /// called. \p Ctx is passed into the handler when it is invoked.
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::setDiagHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 89,
   FQN="llvm::SourceMgr::setDiagHandler", NM="_ZN4llvm9SourceMgr14setDiagHandlerEPFvRKNS_12SMDiagnosticEPvES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgr14setDiagHandlerEPFvRKNS_12SMDiagnosticEPvES4_")
  //</editor-fold>
  public void setDiagHandler(DiagHandlerTy DH) {
    setDiagHandler(DH, (Object/*void P*/ )null);
  }
  public void setDiagHandler(DiagHandlerTy DH, Object/*void P*/ Ctx/*= null*/) {
    DiagHandler = $tryClone(DH);
    DiagContext = Ctx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::getDiagHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 94,
   FQN="llvm::SourceMgr::getDiagHandler", NM="_ZNK4llvm9SourceMgr14getDiagHandlerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr14getDiagHandlerEv")
  //</editor-fold>
  public DiagHandlerTy getDiagHandler() /*const*/ {
    return DiagHandler;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::getDiagContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 95,
   FQN="llvm::SourceMgr::getDiagContext", NM="_ZNK4llvm9SourceMgr14getDiagContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr14getDiagContextEv")
  //</editor-fold>
  public Object/*void P*/ getDiagContext() /*const*/ {
    return DiagContext;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::getBufferInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 97,
   FQN="llvm::SourceMgr::getBufferInfo", NM="_ZNK4llvm9SourceMgr13getBufferInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr13getBufferInfoEj")
  //</editor-fold>
  public /*const*/ SrcBuffer /*&*/ getBufferInfo(/*uint*/int i) /*const*/ {
    assert (isValidBufferID(i));
    return Buffers.$at$Const(i - 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::getMemoryBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 102,
   FQN="llvm::SourceMgr::getMemoryBuffer", NM="_ZNK4llvm9SourceMgr15getMemoryBufferEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr15getMemoryBufferEj")
  //</editor-fold>
  public /*const*/ MemoryBuffer /*P*/ getMemoryBuffer(/*uint*/int i) /*const*/ {
    assert (isValidBufferID(i));
    return Buffers.$at$Const(i - 1).Buffer.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::getNumBuffers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 107,
   FQN="llvm::SourceMgr::getNumBuffers", NM="_ZNK4llvm9SourceMgr13getNumBuffersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr13getNumBuffersEv")
  //</editor-fold>
  public /*uint*/int getNumBuffers() /*const*/ {
    return Buffers.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::getMainFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 111,
   FQN="llvm::SourceMgr::getMainFileID", NM="_ZNK4llvm9SourceMgr13getMainFileIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr13getMainFileIDEv")
  //</editor-fold>
  public /*uint*/int getMainFileID() /*const*/ {
    assert Native.$bool(getNumBuffers());
    return 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::getParentIncludeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 116,
   FQN="llvm::SourceMgr::getParentIncludeLoc", NM="_ZNK4llvm9SourceMgr19getParentIncludeLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr19getParentIncludeLocEj")
  //</editor-fold>
  public SMLoc getParentIncludeLoc(/*uint*/int i) /*const*/ {
    assert (isValidBufferID(i));
    return new SMLoc(Buffers.$at$Const(i - 1).IncludeLoc);
  }

  
  /// Add a new source buffer to this source manager. This takes ownership of
  /// the memory buffer.
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::AddNewSourceBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 123,
   FQN="llvm::SourceMgr::AddNewSourceBuffer", NM="_ZN4llvm9SourceMgr18AddNewSourceBufferESt10unique_ptrINS_12MemoryBufferESt14default_deleteIS2_EENS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgr18AddNewSourceBufferESt10unique_ptrINS_12MemoryBufferESt14default_deleteIS2_EENS_5SMLocE")
  //</editor-fold>
  public /*uint*/int AddNewSourceBuffer(std.unique_ptr<MemoryBuffer> F, 
                    SMLoc IncludeLoc) {
    SrcBuffer NB = null;
    try {
      NB/*J*/= new SrcBuffer();
      NB.Buffer.$assignMove(std.move(F));
      NB.IncludeLoc.$assign(IncludeLoc);
      Buffers.push_back_T$RR(std.move(NB));
      return Buffers.size();
    } finally {
      if (NB != null) { NB.$destroy(); }
    }
  }

  
  /// Search for a file with the specified name in the current directory or in
  /// one of the IncludeDirs.
  ///
  /// If no file is found, this returns 0, otherwise it returns the buffer ID
  /// of the stacked file. The full path to the included file can be found in
  /// \p IncludedFile.
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::AddIncludeFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 45,
   FQN="llvm::SourceMgr::AddIncludeFile", NM="_ZN4llvm9SourceMgr14AddIncludeFileERKSsNS_5SMLocERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm9SourceMgr14AddIncludeFileERKSsNS_5SMLocERSs")
  //</editor-fold>
  public /*uint*/int AddIncludeFile(final /*const*/std.string/*&*/ Filename, 
                SMLoc IncludeLoc, 
                final std.string/*&*/ IncludedFile) {
    ErrorOr<std.unique_ptr<MemoryBuffer> > NewBufOrErr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      IncludedFile.$assign(Filename);
      NewBufOrErr = MemoryBuffer.getFile(new Twine(IncludedFile));
      
      // If the file didn't exist directly, see if it's in an include path.
      for (/*uint*/int i = 0, e = IncludeDirectories.size(); i != e && !NewBufOrErr.$bool();
           ++i) {
        IncludedFile.$assignMove(
            $add_string_string$C($add_string$C_T$C$P(IncludeDirectories.$at(i), path.get_separator().toJavaString()), Filename)
        );
        $c$.clean(NewBufOrErr.$assignMove($c$.track(MemoryBuffer.getFile(new Twine(IncludedFile)))));
      }
      if (!NewBufOrErr.$bool()) {
        return 0;
      }
      
      return $c$.clean(AddNewSourceBuffer($c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(NewBufOrErr.$star()))), new SMLoc(IncludeLoc)));
    } finally {
      if (NewBufOrErr != null) { NewBufOrErr.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Return the ID of the buffer containing the specified location.
  ///
  /// 0 is returned if the buffer is not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::FindBufferContainingLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 66,
   FQN="llvm::SourceMgr::FindBufferContainingLoc", NM="_ZNK4llvm9SourceMgr23FindBufferContainingLocENS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr23FindBufferContainingLocENS_5SMLocE")
  //</editor-fold>
  public /*uint*/int FindBufferContainingLoc(SMLoc Loc) /*const*/ {
    for (/*uint*/int i = 0, e = Buffers.size(); i != e; ++i)  {
      if (Loc.getPointer().$greatereq(Buffers.$at$Const(i).Buffer.$arrow().getBufferStart())
        // Use <= here so that a pointer to the null at the end of the buffer
        // is included as part of the buffer.
         && Loc.getPointer().$lesseq(Buffers.$at$Const(i).Buffer.$arrow().getBufferEnd())) {
        return i + 1;
      }
    }
    return 0;
  }

  
  /// Find the line number for the specified location in the specified file.
  /// This is not a fast method.
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::FindLineNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 148,
   FQN="llvm::SourceMgr::FindLineNumber", NM="_ZNK4llvm9SourceMgr14FindLineNumberENS_5SMLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr14FindLineNumberENS_5SMLocEj")
  //</editor-fold>
  public /*uint*/int FindLineNumber(SMLoc Loc) /*const*/ {
    return FindLineNumber(Loc, 0);
  }
  public /*uint*/int FindLineNumber(SMLoc Loc, /*uint*/int BufferID/*= 0*/) /*const*/ {
    return getLineAndColumn(new SMLoc(Loc), BufferID).first;
  }

  
  /// Find the line and column number for the specified location in the
  /// specified file. This is not a fast method.
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::getLineAndColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 76,
   FQN="llvm::SourceMgr::getLineAndColumn", NM="_ZNK4llvm9SourceMgr16getLineAndColumnENS_5SMLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr16getLineAndColumnENS_5SMLocEj")
  //</editor-fold>
  public std.pairUIntUInt getLineAndColumn(SMLoc Loc) /*const*/ {
    return getLineAndColumn(Loc, 0);
  }
  public std.pairUIntUInt getLineAndColumn(SMLoc Loc, /*uint*/int BufferID/*= 0*/) /*const*/ {
    if (!(BufferID != 0)) {
      BufferID = FindBufferContainingLoc(new SMLoc(Loc));
    }
    assert ((BufferID != 0)) : "Invalid Location!";
    
    /*const*/ MemoryBuffer /*P*/ Buff = getMemoryBuffer(BufferID);
    
    // Count the number of \n's between the start of the file and the specified
    // location.
    /*uint*/int LineNo = 1;
    
    /*const*/char$ptr/*char P*/ BufStart = $tryClone(Buff.getBufferStart());
    /*const*/char$ptr/*char P*/ Ptr = $tryClone(BufStart);
    {
      
      // If we have a line number cache, and if the query is to a later point in the
      // same file, start searching from the last query location.  This optimizes
      // for the case when multiple diagnostics come out of one file in order.
      LineNoCacheTy /*P*/ Cache = getCache(LineNoCache);
      if ((Cache != null)) {
        if (Cache.LastQueryBufferID == BufferID
           && Cache.LastQuery.$lesseq(Loc.getPointer())) {
          Ptr = $tryClone(Cache.LastQuery);
          LineNo = Cache.LineNoOfQuery;
        }
      }
    }
    
    // Scan for the location being queried, keeping track of the number of lines
    // we see.
    for (; SMLoc.getFromPointer(Ptr).$noteq(Loc); Ptr.$preInc())  {
      if (Ptr.$star() == $$LF) {
        ++LineNo;
      }
    }
    
    // Allocate the line number cache if it doesn't exist.
    if (!(LineNoCache != null)) {
      LineNoCache = new LineNoCacheTy();
    }
    
    // Update the line # cache.
    final LineNoCacheTy /*&*/ Cache = $Deref(getCache(LineNoCache));
    Cache.LastQueryBufferID = BufferID;
    Cache.LastQuery = $tryClone(Ptr);
    Cache.LineNoOfQuery = LineNo;
    
    /*size_t*/int NewlineOffs = new StringRef(BufStart, Ptr.$sub(BufStart)).find_last_of(/*STRINGREF_STR*/"\n\015");
    if (NewlineOffs == StringRef.npos) {
      NewlineOffs = ~(/*size_t*/int)0;
    }
    return std.make_pair_uint_uint(LineNo, Ptr.$sub(BufStart) - NewlineOffs);
  }

  
  /// Emit a message about the specified location with the specified string.
  ///
  /// \param ShowColors Display colored messages if output is a terminal and
  /// the default error handler is used.
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::PrintMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 215,
   FQN="llvm::SourceMgr::PrintMessage", NM="_ZNK4llvm9SourceMgr12PrintMessageERNS_11raw_ostreamENS_5SMLocENS0_8DiagKindERKNS_5TwineENS_8ArrayRefINS_7SMRangeEEENS8_INS_7SMFixItEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr12PrintMessageERNS_11raw_ostreamENS_5SMLocENS0_8DiagKindERKNS_5TwineENS_8ArrayRefINS_7SMRangeEEENS8_INS_7SMFixItEEEb")
  //</editor-fold>
  public void PrintMessage(final raw_ostream /*&*/ OS, SMLoc Loc, 
              SourceMgr.DiagKind Kind, 
              final /*const*/ Twine /*&*/ Msg) /*const*/ {
    PrintMessage(OS, Loc, 
              Kind, 
              Msg, new ArrayRef<SMRange>(None, false), 
              new ArrayRef<SMFixIt>(None, false), true);
  }
  public void PrintMessage(final raw_ostream /*&*/ OS, SMLoc Loc, 
              SourceMgr.DiagKind Kind, 
              final /*const*/ Twine /*&*/ Msg, ArrayRef<SMRange> Ranges/*= None*/) /*const*/ {
    PrintMessage(OS, Loc, 
              Kind, 
              Msg, Ranges, 
              new ArrayRef<SMFixIt>(None, false), true);
  }
  public void PrintMessage(final raw_ostream /*&*/ OS, SMLoc Loc, 
              SourceMgr.DiagKind Kind, 
              final /*const*/ Twine /*&*/ Msg, ArrayRef<SMRange> Ranges/*= None*/, 
              ArrayRef<SMFixIt> FixIts/*= None*/) /*const*/ {
    PrintMessage(OS, Loc, 
              Kind, 
              Msg, Ranges, 
              FixIts, true);
  }
  public void PrintMessage(final raw_ostream /*&*/ OS, SMLoc Loc, 
              SourceMgr.DiagKind Kind, 
              final /*const*/ Twine /*&*/ Msg, ArrayRef<SMRange> Ranges/*= None*/, 
              ArrayRef<SMFixIt> FixIts/*= None*/, boolean ShowColors/*= true*/) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      PrintMessage(OS, $c$.track(GetMessage(new SMLoc(Loc), Kind, Msg, new ArrayRef<SMRange>(Ranges), new ArrayRef<SMFixIt>(FixIts))), ShowColors); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Emits a diagnostic to llvm::errs().
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::PrintMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 222,
   FQN="llvm::SourceMgr::PrintMessage", NM="_ZNK4llvm9SourceMgr12PrintMessageENS_5SMLocENS0_8DiagKindERKNS_5TwineENS_8ArrayRefINS_7SMRangeEEENS6_INS_7SMFixItEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr12PrintMessageENS_5SMLocENS0_8DiagKindERKNS_5TwineENS_8ArrayRefINS_7SMRangeEEENS6_INS_7SMFixItEEEb")
  //</editor-fold>
  public void PrintMessage(SMLoc Loc, SourceMgr.DiagKind Kind, 
              final /*const*/ Twine /*&*/ Msg) /*const*/ {
    PrintMessage(Loc, Kind, 
              Msg, new ArrayRef<SMRange>(None, false), 
              new ArrayRef<SMFixIt>(None, false), true);
  }
  public void PrintMessage(SMLoc Loc, SourceMgr.DiagKind Kind, 
              final /*const*/ Twine /*&*/ Msg, ArrayRef<SMRange> Ranges/*= None*/) /*const*/ {
    PrintMessage(Loc, Kind, 
              Msg, Ranges, 
              new ArrayRef<SMFixIt>(None, false), true);
  }
  public void PrintMessage(SMLoc Loc, SourceMgr.DiagKind Kind, 
              final /*const*/ Twine /*&*/ Msg, ArrayRef<SMRange> Ranges/*= None*/, 
              ArrayRef<SMFixIt> FixIts/*= None*/) /*const*/ {
    PrintMessage(Loc, Kind, 
              Msg, Ranges, 
              FixIts, true);
  }
  public void PrintMessage(SMLoc Loc, SourceMgr.DiagKind Kind, 
              final /*const*/ Twine /*&*/ Msg, ArrayRef<SMRange> Ranges/*= None*/, 
              ArrayRef<SMFixIt> FixIts/*= None*/, boolean ShowColors/*= true*/) /*const*/ {
    PrintMessage(llvm.errs(), new SMLoc(Loc), Kind, Msg, new ArrayRef<SMRange>(Ranges), new ArrayRef<SMFixIt>(FixIts), ShowColors);
  }

  
  /// Emits a manually-constructed diagnostic to the given output stream.
  ///
  /// \param ShowColors Display colored messages if output is a terminal and
  /// the default error handler is used.
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::PrintMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 198,
   FQN="llvm::SourceMgr::PrintMessage", NM="_ZNK4llvm9SourceMgr12PrintMessageERNS_11raw_ostreamERKNS_12SMDiagnosticEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr12PrintMessageERNS_11raw_ostreamERKNS_12SMDiagnosticEb")
  //</editor-fold>
  public void PrintMessage(final raw_ostream /*&*/ OS, final /*const*/ SMDiagnostic /*&*/ Diagnostic) /*const*/ {
    PrintMessage(OS, Diagnostic, 
              true);
  }
  public void PrintMessage(final raw_ostream /*&*/ OS, final /*const*/ SMDiagnostic /*&*/ Diagnostic, 
              boolean ShowColors/*= true*/) /*const*/ {
    // Report the message with the diagnostic handler if present.
    if ((DiagHandler != null)) {
      DiagHandler.$call(Diagnostic, DiagContext);
      return;
    }
    if (Diagnostic.getLoc().isValid()) {
      /*uint*/int CurBuf = FindBufferContainingLoc(Diagnostic.getLoc());
      assert ((CurBuf != 0)) : "Invalid or unspecified location!";
      PrintIncludeStack(new SMLoc(getBufferInfo(CurBuf).IncludeLoc), OS);
    }
    
    Diagnostic.print((/*const*/char$ptr/*char P*/ )null, OS, ShowColors);
  }

  
  /// Return an SMDiagnostic at the specified location with the specified
  /// string.
  ///
  /// \param Msg If non-null, the kind of message (e.g., "error") which is
  /// prefixed to the message.
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::GetMessage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 135,
   FQN="llvm::SourceMgr::GetMessage", NM="_ZNK4llvm9SourceMgr10GetMessageENS_5SMLocENS0_8DiagKindERKNS_5TwineENS_8ArrayRefINS_7SMRangeEEENS6_INS_7SMFixItEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr10GetMessageENS_5SMLocENS0_8DiagKindERKNS_5TwineENS_8ArrayRefINS_7SMRangeEEENS6_INS_7SMFixItEEE")
  //</editor-fold>
  public SMDiagnostic GetMessage(SMLoc Loc, SourceMgr.DiagKind Kind, 
            final /*const*/ Twine /*&*/ Msg) /*const*/ {
    return GetMessage(Loc, Kind, 
            Msg, 
            new ArrayRef<SMRange>(None, false), 
            new ArrayRef<SMFixIt>(None, false));
  }
  public SMDiagnostic GetMessage(SMLoc Loc, SourceMgr.DiagKind Kind, 
            final /*const*/ Twine /*&*/ Msg, 
            ArrayRef<SMRange> Ranges/*= None*/) /*const*/ {
    return GetMessage(Loc, Kind, 
            Msg, 
            Ranges, 
            new ArrayRef<SMFixIt>(None, false));
  }
  public SMDiagnostic GetMessage(SMLoc Loc, SourceMgr.DiagKind Kind, 
            final /*const*/ Twine /*&*/ Msg, 
            ArrayRef<SMRange> Ranges/*= None*/, 
            ArrayRef<SMFixIt> FixIts/*= None*/) /*const*/ {
    
    // First thing to do: find the current buffer containing the specified
    // location to pull out the source line.
    SmallVector<std.pairUIntUInt> ColRanges/*J*/= new SmallVector<std.pairUIntUInt>(4, new std.pairUIntUInt());
    std.pairUIntUInt LineAndCol/*J*/= new std.pairUIntUInt();
    /*const*/char$ptr/*char P*/ BufferID = $("<unknown>");
    std.string LineStr/*J*/= new std.string();
    if (Loc.isValid()) {
      /*uint*/int CurBuf = FindBufferContainingLoc(new SMLoc(Loc));
      assert ((CurBuf != 0)) : "Invalid or unspecified location!";
      
      /*const*/ MemoryBuffer /*P*/ CurMB = getMemoryBuffer(CurBuf);
      BufferID = $tryClone(CurMB.getBufferIdentifier());
      
      // Scan backward to find the start of the line.
      /*const*/char$ptr/*char P*/ LineStart = $tryClone(Loc.getPointer());
      /*const*/char$ptr/*char P*/ BufStart = $tryClone(CurMB.getBufferStart());
      while ($noteq_ptr(LineStart, BufStart) && LineStart.$at(-1) != $$LF
         && LineStart.$at(-1) != $$CR) {
        LineStart.$preDec();
      }
      
      // Get the end of the line.
      /*const*/char$ptr/*char P*/ LineEnd = $tryClone(Loc.getPointer());
      /*const*/char$ptr/*char P*/ BufEnd = $tryClone(CurMB.getBufferEnd());
      while ($noteq_ptr(LineEnd, BufEnd) && LineEnd.$at(0) != $$LF && LineEnd.$at(0) != $$CR) {
        LineEnd.$preInc();
      }
      LineStr.$assignMove(new std.string(LineStart, LineEnd));
      
      // Convert any ranges to column ranges that only intersect the line of the
      // location.
      for (/*uint*/int i = 0, e = Ranges.size(); i != e; ++i) {
        SMRange R = new SMRange(Ranges.$at(i));
        if (!R.isValid()) {
          continue;
        }
        
        // If the line doesn't contain any part of the range, then ignore it.
        if (R.Start.getPointer().$greater(LineEnd) || R.End.getPointer().$less(LineStart)) {
          continue;
        }
        
        // Ignore pieces of the range that go onto other lines.
        if (R.Start.getPointer().$less(LineStart)) {
          R.Start.$assignMove(SMLoc.getFromPointer(LineStart));
        }
        if (R.End.getPointer().$greater(LineEnd)) {
          R.End.$assignMove(SMLoc.getFromPointer(LineEnd));
        }
        
        // Translate from SMLoc ranges to column ranges.
        // FIXME: Handle multibyte characters.
        ColRanges.push_back(std.make_pair_int2uint_int2uint(R.Start.getPointer().$sub(LineStart), 
                    R.End.getPointer().$sub(LineStart)));
      }
      
      LineAndCol.$assignMove(getLineAndColumn(new SMLoc(Loc), CurBuf));
    }
    
    return new SMDiagnostic(/*Deref*/this, new SMLoc(Loc), new StringRef(BufferID), LineAndCol.first, 
        LineAndCol.second - 1, Kind, new StringRef(Msg.str()), 
        new StringRef(LineStr), new ArrayRef<std.pairUIntUInt>(ColRanges, false), new ArrayRef<SMFixIt>(FixIts));
  }

  
  /// Prints the names of included files and the line of the file they were
  /// included from. A diagnostic handler can use this before printing its
  /// custom formatted message.
  ///
  /// \param IncludeLoc The location of the include.
  /// \param OS the raw_ostream to print on.
  //<editor-fold defaultstate="collapsed" desc="llvm::SourceMgr::PrintIncludeStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 121,
   FQN="llvm::SourceMgr::PrintIncludeStack", NM="_ZNK4llvm9SourceMgr17PrintIncludeStackENS_5SMLocERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm9SourceMgr17PrintIncludeStackENS_5SMLocERNS_11raw_ostreamE")
  //</editor-fold>
  public void PrintIncludeStack(SMLoc IncludeLoc, final raw_ostream /*&*/ OS) /*const*/ {
    if (IncludeLoc.$eq(new SMLoc())) {
      return; // Top of stack.
    }
    
    /*uint*/int CurBuf = FindBufferContainingLoc(new SMLoc(IncludeLoc));
    assert ((CurBuf != 0)) : "Invalid or unspecified location!";
    
    PrintIncludeStack(new SMLoc(getBufferInfo(CurBuf).IncludeLoc), OS);
    
    OS.$out(/*KEEP_STR*/"Included from ").$out(
        getBufferInfo(CurBuf).Buffer.$arrow().getBufferIdentifier()
    ).$out(
        /*KEEP_STR*/$COLON
    ).$out_uint(FindLineNumber(new SMLoc(IncludeLoc), CurBuf)).$out(/*KEEP_STR*/$COLON_LF);
  }

  
  @Override public String toString() {
    return "" + "Buffers=" + Buffers // NOI18N
              + ", IncludeDirectories=" + IncludeDirectories // NOI18N
              + ", LineNoCache=" + NativeTrace.getIdentityStr(LineNoCache) // NOI18N
              + ", DiagHandler=" + DiagHandler // NOI18N
              + ", DiagContext=" + NativeTrace.getIdentityStr(DiagContext); // NOI18N
  }
}
